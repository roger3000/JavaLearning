package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Server {
	private ServerSocket serverSocket;
	private Socket socket;
	private Collection<Socket> clients = new ArrayList<Socket>();
	//初始化服务器
	public Server() {
		try {
			//初始化服务器端口
			serverSocket = new ServerSocket(8088);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//定义服务器的运行逻辑
	public void start() {
		try {
			
			
			
			//开始接收客户机消息
			while(true) {
				//初始化Socket
				System.out.println("等待客户机连接");
				socket = serverSocket.accept();
				System.out.println("客户机:"+socket.getInetAddress()+"已连接");
				
				clients.add(socket);

				//定义输出流
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
				//发送欢迎信息
				pw.println("你好");
				
				//使用多线程来接收客户机信息
				Sender ms = new Sender();
				Thread t = new Thread(ms);
				t.start();
				
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	
	class Sender implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			try {
				//定义输入流
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
				
				while(true) {
					//接收信息
					String message = br.readLine();
					//打印信息
					System.out.println(socket.getInetAddress()+"说:"+message);
					
					//去除集合中所有null
					clients.removeAll(Collections.singleton(null));
					
					for (Socket socket : clients) {
						//定义输出流

						if(socket != Server.this.socket) {
							PrintWriter pw = new PrintWriter(
									new OutputStreamWriter(
											socket.getOutputStream(),"utf-8"),true);
							pw.println(socket.getInetAddress()+"说:"+message);
						}
					}
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
