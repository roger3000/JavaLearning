package day04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo1 {
	public static void main(String[] args) throws IOException {
		/*
		 * 创建文件输入流用于读取原文件
		 * 创建文件输出流用于写入复制文件
		 * 
		 * 顺序从原文件中读取字节写入到复制的文件中完成复制工作
		 */
		
		FileInputStream fis = 
				new FileInputStream("music.mp3");
		FileOutputStream fos =
				new FileOutputStream("music_cp.mp3");
		byte[] data = new byte[1024*10];			
		int len = -1;
		
		while((len=fis.read(data)) != -1) {
			fos.write(data,0,len);
		}
		System.out.println("复制完毕");
		
		fis.close();
		fos.close();
	}
}
