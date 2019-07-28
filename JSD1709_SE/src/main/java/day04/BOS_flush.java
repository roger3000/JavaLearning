package day04;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BOS_flush {
	public static void main(String[] args) throws IOException{
		FileOutputStream fos = 
				new FileOutputStream("bos.txt");
		BufferedOutputStream bos =
				new BufferedOutputStream(fos);
		
		String str = "夜空中最亮的星,能否听清";
		byte[] b = str.getBytes();
		
		bos.write(b);
		bos.flush();
		
		System.out.println("写出完毕");
		bos.close(); 		//关闭时 缓冲流会flush
	}
}
