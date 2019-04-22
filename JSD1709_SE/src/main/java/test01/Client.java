package src.main.java.test01;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private Scanner scanner;
    public Client(){
        try {
            System.out.println("正在连接客户端");
            socket = new Socket("localhost",8088);
            System.out.println("客户端连接成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(inputStreamReader);
            System.out.println(br.readLine());

            System.out.println("请输入信息:");
            scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            PrintWriter printWriter = new PrintWriter(outputStreamWriter);
            printWriter.println(input);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Client client = new Client();
        client.run();
    }
}
