package day04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 在流链接中使用PrintWriter
 * @author 许皓泉
 *
 */
public class PW_println2 {
	public static void main(String[] args) throws IOException{
		FileOutputStream fos =
				new FileOutputStream("pw2.txt");
		
		//若希望制定字符集 则需要手动链接转换流
		OutputStreamWriter osw =
				new OutputStreamWriter(fos, "GBK");
		
		PrintWriter pw = 
				new PrintWriter(osw);
		
		pw.println("我");
		System.out.println("输出完毕");
		
		pw.close();
		
	}
}
