package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDemo01 {
	private Socket socket;
	public ClientDemo01(){
		try {
			System.out.println("正在连接服务端");
			socket = new Socket("localhost",8088);
			System.out.println("服务端连接成功");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public void run() {
		try {
			//接收服务端信息
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			System.out.println("服务端说:"+br.readLine());
			
			//向服务端输出信息
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
			Scanner scanner = new Scanner(System.in);
			
			while(true) {
				System.out.println("请输入内容：");
				String input = scanner.nextLine();
				if(input.equals("exit")) {
					pw.println(input);
					break;
				}
				pw.println(input);			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		ClientDemo01 multiServer = new ClientDemo01();
		multiServer.run();
	}
}
