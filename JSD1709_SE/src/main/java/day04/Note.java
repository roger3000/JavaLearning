package day04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Note {
	public static void main(String[] args) throws IOException{
		Scanner scanner =
				new Scanner(System.in);
		
		System.out.println("请输入文件名");
		String filename = scanner.nextLine();
		
		FileOutputStream fos =
				new FileOutputStream(filename, true);
		OutputStreamWriter osw = 
				new OutputStreamWriter(fos, "UTF-8");
		PrintWriter pw =
				new PrintWriter(osw);
		
		System.out.println("请输入内容,当输入exit时程序退出");
		
		String line = null;
		while(true) {
			line = scanner.nextLine();
			if("exit".equals(line)) {
				break;
			}
			pw.println(line);
		}
		

		pw.close();
		scanner.close();
	}
}
