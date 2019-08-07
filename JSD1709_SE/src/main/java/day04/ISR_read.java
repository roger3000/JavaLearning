package day04;

import java.io.*;
import java.util.Arrays;

public class ISR_read {
	public static void main(String[] args) throws IOException {
//		FileInputStream fis =
//				new FileInputStream("osw.txt");
//
//		InputStreamReader isr =
//				new InputStreamReader(fis);
//
//		char[] chs = new char[2];
//
//
//		while(isr.read(chs) != -1) {
//			System.out.print(Arrays.toString(chs));
//		}
//
//		isr.close();

		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("log.txt")))) {

			String i ;
			while ((i = bufferedReader.readLine()) != null ){
				System.out.println(i);
			}
		}
	}
}
