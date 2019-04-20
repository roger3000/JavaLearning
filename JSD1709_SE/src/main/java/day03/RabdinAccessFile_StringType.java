package day03;

import java.io.RandomAccessFile;

public class RabdinAccessFile_StringType {
	public static void main(String[] args) {
		try {
			RandomAccessFile raf =
					new RandomAccessFile("raf.txt", "rw");
			String str = 
					"你在南方的艳阳里，大雪纷飞";
			/*
			 * 常用字符集：
			 * GBK
			 * UTF-8
			 */
			byte[] data = str.getBytes("UTF-8");
			
			raf.write(data);
			System.out.println("写入成功");
			
			raf.seek(0);
			//读取多少字节?
			byte[] arr = new byte[100];
			int len = raf.read(arr);
			System.out.println("实际读取了"+len+"个字节");
			
			String s = new String(arr, "UTF-8").trim();
			System.out.println(s);
			
			raf.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
