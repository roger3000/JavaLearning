package day04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ISR_read {
	public static void main(String[] args) throws IOException{
		FileInputStream fis = 
				new FileInputStream("osw.txt");
		
		InputStreamReader isr =
				new InputStreamReader(fis);
		
		char[] chs = new char[2];
		
		
		while(isr.read(chs) != -1) {
			System.out.print(Arrays.toString(chs));
		}
		
		isr.close();
	}
}
