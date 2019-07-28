package cn.tedu.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
					
				//获取输入流
				InputStream is = socket.getInputStream();
				
				int d = -1;
				StringBuilder sb = 
						new StringBuilder();
				char c1=0,c2 =0;
				while((d = is.read()) != -1) {
					c2 = (char)d;
					if(c1 ==13 && c2 == 10) {
						break;
					}
					sb.append((char)d);
					c1 = c2;
				}
					System.out.println(sb);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
