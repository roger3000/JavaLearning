package day06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * java.io.BufferedReader
 * 缓冲字符输入流
 * 可以按行读取字符串
 * 
 * @author 许皓泉
 *
 */
public class BR_readline {
	public static void main(String[] args) throws IOException{
		/*
		 * 将当前类的源文件读取出来并输出到控制台
		 */
		FileInputStream fis = 
				new FileInputStream("D:\\eclipseWorkSpace\\JSD1709_SE\\src\\main\\java\\day06\\BR_readline.java");
		
		InputStreamReader isr = 
				new InputStreamReader(fis);
		
		BufferedReader br = 
				new BufferedReader(isr);
		
		String line = null;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		br.close();
	}
}
