package cn.tedu.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import cn.tedu.http.HttpRequest;

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
				HttpRequest request = 
						new HttpRequest(
								socket.getInputStream()
								);
				System.out.println("method:"+request.getMethod());
				System.out.println("uri:"+request.getUri());
				System.out.println("protocol:"+request.getProtocol());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
