package day05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exception_API {
	public static void main(String[] args) {
		try {
			FileInputStream fis = 
					new FileInputStream("fuckyou.txt");
			InputStreamReader isr = 
					new InputStreamReader(fis);
			BufferedReader br = 
					new BufferedReader(isr);
			br.close();
			System.out.println(isr.read(new char[100]));
		} catch (IOException e) {
			//输出错误堆栈信息,有助于定位错误并调整
			e.printStackTrace();
		}
	}
}
