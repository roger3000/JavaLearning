package cn.tedu.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
				
				File file = new File("webapps"+request.getUri());
				if(file.exists()) {
					System.out.println("已找到文件");
					OutputStream out = socket.getOutputStream();
					out.write("HTTP/1.1 200 OK".getBytes("ISO8859-1"));
					out.write(13);
					out.write(10);
					System.out.println("状态行发送完毕");
					
					out.write("Content-Type:text/html".getBytes("ISO8859-1"));
					out.write(13);
					out.write(10);
					out.write(("Content-Length:"+file.length()).getBytes());
					out.write(13);
					out.write(10);
					out.write(13);
					out.write(10);
					System.out.println("所有头发送完毕");
					
					FileInputStream fis = new FileInputStream(file);
					int len = -1;
					byte[] data = new byte[1024*10];
					while((len = fis.read(data)) != -1) {
						out.write(data,0,len);
					}
					System.out.println("正文发送完毕");
					fis.close();
					
				}else {
					System.out.println("文件不存在");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
