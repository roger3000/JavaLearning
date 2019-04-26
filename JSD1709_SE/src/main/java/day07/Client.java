package day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	Socket socket;
	public Client() {
		try {
			System.out.println("正在连接服务器");
			socket = new Socket("localhost", 8088);
			System.out.println("服务器连接成功");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public void start() {
		try {
			//定义输出流
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			//使用多线程接收服务端消息
			Reciver reciver = new Reciver();
			Thread thread = new Thread(reciver);
			thread.start();
			
			//向服务器发送消息
			while(true) {
				Thread.sleep(1000);
				System.out.println("请输入消息:");
				Scanner scanner = new Scanner(System.in);
				String output = scanner.nextLine();
				pw.println(output);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
	
	class Reciver implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			try {
				BufferedReader br;
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				String message;
				//循环接收服务器消息
				while((message = br.readLine()) != null) {
					System.out.println(message);
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
	
	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}
}
