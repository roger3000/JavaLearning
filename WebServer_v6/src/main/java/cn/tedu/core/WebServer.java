package cn.tedu.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import cn.tedu.http.HttpRequest;
import cn.tedu.http.HttpResponse;

public class WebServer {
	private ServerSocket ss;
	private Socket socket;
	private HttpResponse response;
	private HttpRequest request;
	
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
				request = new HttpRequest(
								socket.getInputStream()
								);
				System.out.println("requestLine:" + request.getRequestLine());
				//创建响应对象
				response = new HttpResponse(
								socket.getOutputStream()
								);
				/*
				 * 先判断用户亲求的是否为业务功能
				 */
				//是否请求注册功能
				if("/myweb/reg".equals(request.getRequestLine())) {
					System.out.println("开始注册");
					File reg_file = new File("webapps/myweb/reg.html");
					response.setEntity(reg_file);
					response.flush();
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
						File file = new File(
								"webapps/myweb/reg_success.html"
								);
						response.setEntity(file);
						response.flush();
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						if(pw != null) {
							pw.close();
						}
					}
					
					System.out.println("注册完毕");
				}else {
					//查看请求的页面是否存在
					File  file = new File(
							"webapps"+request.getRequestLine()
							);
					System.out.println(
							"uri:"+request.getUri()
							);
					if(file.exists()) {
						System.out.println("文件存在");
						response.setEntity(file);;
						response.flush();
						
					}else {
						System.out.println("文件不存在");
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
