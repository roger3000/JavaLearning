package day04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲流 
 * BufferedInputStream
 * BufferedOutputStream
 * 作用是加快读写速度
 * @author lifer
 *
 */
public class CopyDemo2 {
	public static void main(String[] args) throws IOException{
		FileInputStream fis = 
				new FileInputStream("music.mp3");
		BufferedInputStream bis = 
				new BufferedInputStream(fis);
		
		FileOutputStream fos =
				new FileOutputStream("music_cp2.mp3");
		BufferedOutputStream bos = 
				new BufferedOutputStream(fos);
		int d = -1;
		
		while((d=bis.read()) != -1) {
			bos.write(d);
		}
		System.out.println("复制完毕");
		
		bis.close();
		bos.close();
	}
}
