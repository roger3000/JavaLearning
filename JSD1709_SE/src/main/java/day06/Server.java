package day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/*
 * 聊天室服务端
 * java.net.ServerSocket
 * 运行在server端的Serversocket
 * 主要作用有两个
 * 1.向系统申请一个端口
 * 
 * 2.监听该端口
 */
public class Server {
	
	private ServerSocket server;
	private Socket socket;
	
	public Server() {
		try {
			/*
			 *实例化ServerSocket的同时申请服务端口 
			 */
			System.out.println("正在启动服务端......");
			server = new ServerSocket(8088);
			System.out.println("服务端启动完毕!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		try {
			/*
			 * ServerSocket提供的方法
			 * Socket accept()
			 * 该方法时一个阻塞方法
			 * 调用到该方法后程序"卡住"
			 * 并等待客户端的连接,
			 * 一旦一个客户端连接了,那么就会返回又给Socket实例
			 * 哦那个过该实例即可与连接的客户端进行通讯
			 */
			System.out.println("等待客户端连接......");
			System.out.println("server"+server);
			socket = server.accept();
			System.out.println("server"+server);
			System.out.println("客户端连接成功");
			
			OutputStream os = socket.getOutputStream();
			String str = "你好 服务端";
			byte[] b = str.getBytes("UTF-8");
			os.write(b);

//			byte[] data = new byte[1024];
			java.io.InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			while(true) {
				String str1 = br.readLine();
				if("quit".equals(str1)) {
					is.close();
					break;
				}
				System.out.println("客户端说"+str1);
			}
			System.out.println("中断连接");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	
}
