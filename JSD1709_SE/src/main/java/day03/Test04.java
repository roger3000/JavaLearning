package day03;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Test04 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf =
				new RandomAccessFile("emp.dat", "rw");
		
		for(int i=0;i<raf.length()/80;i++) {
			String name = readRaf(raf, 32);
			String age = readRaf(raf, 4);
			String gender = readRaf(raf, 10);
			String salary = readRaf(raf, 4);
			String hiredate = readRaf(raf, 30);
			
			System.out.println(name+","+age+","+gender+","+salary+","+hiredate);
		}
		
		raf.close();
	}
	
	public static String readRaf(RandomAccessFile raf, int len) throws IOException{
		byte[] b = new byte[len];
		raf.read(b);
		String str = new String(b,"UTF-8").trim();
		return str;
	}
}
