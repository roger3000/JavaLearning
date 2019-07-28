package day06;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	/*
	 * java.net.Socket
	 * 封装了TCP通讯协议,中文翻译时:套接字
	 * 使用Socket的大致步骤
	 * 1:实例化Socket 同时制定链接的服务端
	 * 的IP和端口并与服务端建立链接
	 * 2:通过Socket船舰两个流,一个输入流一个输出流
	 * 通过输入流读取远端计算机发送过来的数据
	 * 通过输出流将数据发送给对方计算机
	 */
	private Socket socket;

	//用来初始化客户端
	private Client() {
		try {
			/*
			 * 实例化socket时需要传入两个参数
			 * 1 IP
			 * 2 端口号
			 */
			System.out.println("正在连接客户端");
			socket = new Socket(
					"localhost",
					8088);
			System.out.println("客户端连接成功");


		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//程序的启动方法
	public void start() {
		try {
			InputStream is = socket.getInputStream();
			byte[] b = new byte[1024*10];
			int len = is.read(b);
			String str = new String(b,0,len,"UTF-8");
			System.out.println(str);

			Scanner scanner = new Scanner(System.in);
			
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");
			PrintWriter pw = new PrintWriter(osw,true);
			
			while(true) {
				System.out.println("请开始输入内容");
				String input = scanner.nextLine();
//				byte[] data = input.getBytes();
				if("quit".equals(input)) {
					pw.println(input);
					out.close();
					break;
				}
				pw.println(input);
			}
			System.out.println("写出完毕");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Client client = new Client();
		client.start();
	}
}
