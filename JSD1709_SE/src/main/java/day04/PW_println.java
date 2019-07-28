package day04;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 缓冲字符流
 * 特点是可以按行读写字符串
 * 
 * java.io.BufferedWriter 
 * java.io.BufferedReader
 * 
 * PrintWriter是常用的缓冲字符流
 * 
 * @author 许皓泉
 *
 */
public class PW_println {
	public static void main(String[] args) throws IOException {
		/*
		 * pw提供了直接写文件的相关构造方法
		 * PrintWriter（String path）
		 * PrintWriter(File file)
		 */
		PrintWriter pw = 
				new PrintWriter("pw.txt");
		pw.println("你说你想在海边买一所房子");
		pw.println("和你可爱的松狮一起住在哪里");
		
		System.out.println("输出完毕！");
		
		pw.close();
	}
}
