package cn.tedu.core;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cn.tedu.http.HttpRequest;
import cn.tedu.http.HttpResponse;
import servlets.LoginServlet;
import servlets.RegServlet;
import servlets.HttpServlet;

public class WebServer extends HttpServlet {
	private ServerSocket ss;
	
	private ExecutorService threadPool;

	public WebServer() {
		try {
			System.out.println("正在初始化服务器");
			ss = new ServerSocket(8088);
			threadPool = Executors.newFixedThreadPool(30);
			System.out.println("服务器初始化完毕");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start() {
		try {
			while (true) {
//				System.out.println("等待客户端连接.....");
				Socket socket = ss.accept();
				ClientHandler ch = new ClientHandler(socket);
				threadPool.execute(ch);
//				System.out.println("一个客户端连接上了");				
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

	class ClientHandler implements Runnable {
		private Socket socket;

		public ClientHandler(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				System.out.println("处理客户端请求!");
				// 根据输入流解析请求
				HttpRequest request = new HttpRequest(socket.getInputStream());
				// 创建响应对象
				HttpResponse response = new HttpResponse(socket.getOutputStream());
				// 打桩
				System.out.println("requestLine:" + request.getRequestLine());
				/*
				 * 先判断用户亲求的是否为业务功能
				 */
				// 是否请求注册功能
				if (ServerContext.servletMapping.containsKey(request.getRequestLine())) {
					String className = ServerContext.servletMapping.get(request.getRequestLine());

					Class cls = Class.forName(className);
					Object obj = cls.newInstance();
					if (obj instanceof HttpServlet) {
						HttpServlet servlet = (HttpServlet) obj;
						servlet.service(request, response);
					} else {
						throw new RuntimeException("请求:" + request.getRequestLine() + "找不到处理类:");
					}
				} else {
					// 查看请求的页面是否存在
					File file = new File("webapps" + request.getRequestLine());
					if (file.exists()) {
						//响应客户端
						forward(request.getRequestLine(), request, response);
					} else {
						//设置状态代码
						response.setStatusCode(HttpContext.STATUS_CODE_NOE_FOUND);
						forward("/web/web/404.html", request, response);
					}
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
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

	}
}
