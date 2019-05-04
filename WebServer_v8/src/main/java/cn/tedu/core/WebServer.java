package cn.tedu.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import cn.tedu.http.HttpRequest;
import cn.tedu.http.HttpResponse;

public class WebServer {
	private ServerSocket ss;
	private Socket socket;
	
	public WebServer() {
		try {
			System.out.println("正在初始化服务器");
			ss = new ServerSocket(8088);
			System.out.println("服务器初始化完毕");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		try {
			while (true) {
				System.out.println("等待客户端连接.....");
				socket = ss.accept();
				System.out.println("一个客户端连接上了");				
				ClientHandler ch = new ClientHandler(socket);
				Thread t1 = new Thread(ch);
				t1.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		WebServer ws = new WebServer();
		ws.start();
	}
	
	class ClientHandler implements Runnable{
		private Socket socket;
		
		public ClientHandler(Socket socket) {
			this.socket = socket;
		}
		
		public void run() {
			try {
				System.out.println("处理客户端请求!");
				//根据输入流解析请求
				HttpRequest request = new HttpRequest(
								socket.getInputStream()
								);
				System.out.println("requestLine:" + request.getRequestLine());
				//创建响应对象
				HttpResponse response = new HttpResponse(
								socket.getOutputStream()
								);
				/*
				 * 先判断用户亲求的是否为业务功能
				 */
				//是否请求注册功能
				if("/myweb/reg".equals(request.getRequestLine())) {
					System.out.println("开始注册");
					forward("/myweb/reg.html", request, response);
					/*
					 * 首先获取用户输入的注册信息
					 */
					String username = request.getParameter("username");
					String pwd = request.getParameter("password");
					String nickname = request.getParameter("nickname");
					System.out.println(username+","+pwd+","+nickname);
					
					PrintWriter pw = null;
					try {
						pw = new PrintWriter(
								new OutputStreamWriter(
										new FileOutputStream("user.txt",true
												)
										)
								);
						pw.println(username+","+pwd+","+nickname);
						
						forward("/myweb/reg_success.html", request, response);
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						if(pw != null) {
							pw.close();
						}
					}
					
					System.out.println("注册完毕");
				}else if ("/myweb/login".equals(request.getRequestLine())) {
					System.out.println("处理登陆");
					String username = request.getParameter("username");
					String password = request.getParameter("password");
					System.out.println(username+","+password);
					
					BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("user.txt"), "utf-8"));
					
					String line = null;
					boolean login = false;
					while((line = br.readLine()) != null) {
						String[] infos = line.split(",");
						String user = infos[0];
						String pwd = infos[1];
						if(user.equals(username) && pwd.equals(password)) {
							login = true;
							break;
						}
					}
					if(login) {
						System.out.println("登陆成功");
						forward("/myweb/login_success.html", request, response);
					}else {
						System.out.println("登陆失败");
						forward("/myweb/login_error.html", request, response);
					}
				}else{
					//查看请求的页面是否存在
					File  file = new File(
							"webapps"+request.getRequestLine()
							);
					if(file.exists()) {
						forward(request.getRequestLine(), request, response);
					}else {
						System.out.println("文件不存在");
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		/**
		 * 跳转页面
		 */
		private void forward(String path, HttpRequest request, HttpResponse response) {
			try {
				File file = new File("webapps"+path);
				response.setEntity(file);
				response.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
