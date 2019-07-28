package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDemo03 {
	private Socket socket;

	public ClientDemo03() {
		try {
			System.out.println("正在连接服务端");
			socket = new Socket("localhost", 8080);
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
	public void Start() {
		try {
			//读取服务端消息
			ServerHandler serverHandler = new ServerHandler();
			Thread t1 = new Thread(serverHandler);
			t1.start();
			
			// 向服务端输出信息
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			
			System.out.println("请输入内容：");
			Scanner scanner = new Scanner(System.in);
			while (true) {
				String input = scanner.nextLine();
				if (input.equals("exit")) {
					System.out.println("结束!");
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


	private class ServerHandler implements Runnable {
		// 读取服务端信息
		
		public void run() {
			BufferedReader br;
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				System.out.println("服务端说:" + br.readLine());
				String message = null;
				while ((message = br.readLine()) != null) {
					System.out.println(message);
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
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
	}
	
	
	public static void main(String[] args) {
		ClientDemo03 multiServer = new ClientDemo03();
		multiServer.Start();
	}
}
