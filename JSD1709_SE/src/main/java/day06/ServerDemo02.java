package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo02 {
	private ServerSocket sc;
	private Socket	socket;
	
	public ServerDemo02() {
		try {
			System.out.println("正在启动服务端");
			sc = new ServerSocket(8080);
			System.out.println("服务端启动成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println("等待客户端链接");
				socket = sc.accept();
				System.out.println("客户端连接成功");
				
				ClientHandler01 ch = new ClientHandler01(socket);
				Thread t = new Thread(ch);
				t.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	public static void main(String[] args) {
		ServerDemo02 mc = new ServerDemo02();
		mc.run();
	}
}

class ClientHandler01 implements Runnable{
	private Socket socket;
	public ClientHandler01(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			//接收服务端信息
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			
			//向服务端发送欢迎信息
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"),true);		
			pw.println("你好,客户端");
			while(true) {
				String str = br.readLine();
				if(str.equals("exit")) {
					System.out.println("结束");
					break;
				}
				System.out.println("客户端说："+str);
				pw.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
}
