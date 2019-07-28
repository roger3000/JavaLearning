package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ServerDemo03 {
	private ServerSocket sc;
	private Socket	socket;
	private PrintWriter[] allOut;
	
	public ServerDemo03() {
		try {
			System.out.println("正在启动服务端");
			sc = new ServerSocket(8080);
			allOut = new PrintWriter[0];
			System.out.println("服务端启动成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		try {
			while(true) {
				System.out.println("等待客户端链接");
				socket = sc.accept();
				System.out.println("客户端连接成功");
				
				ClientHandler03 ch = new ClientHandler03(socket);
				Thread t = new Thread(ch);
				t.start();
			}
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ServerDemo03 mc = new ServerDemo03();
		mc.start();
	}
	
	class ClientHandler03 implements Runnable{
		private Socket socket;
		private String host;
		
		public ClientHandler03(Socket socket) {
			this.socket = socket;
			InetAddress address = socket.getInetAddress();
			host = address.getHostAddress();
		}
		
		public void run() {
			PrintWriter pw = null;
			try {
				//接收服务端信息
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
				
				//向服务端发送信息
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"),true);
				allOut = Arrays.copyOf(allOut, allOut.length+1);
				allOut[allOut.length-1] = pw;
				pw.println("你好,客户端");
				
				String line = null;
				while((line = br.readLine()) != null) {
					if(line.equals("exit")) {
						System.out.println(host+":结束");
						break;
					}
					System.out.println("客户端说："+line);
					//回复所有客户端
					for (PrintWriter printWriter : allOut) {
						if(printWriter != null) {
							printWriter.println(host+":"+line);
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				//将该客户端的输出流从共享集合中删除
				for (int i = 0; i < allOut.length; i++) {
					if (allOut[i] == pw) {
						//与数组最后一个元素交换
						allOut[i] = allOut[allOut.length-1];
						//缩容
						Arrays.copyOf(allOut, allOut.length-1);
						break;
					}
				}
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
