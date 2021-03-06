package day03;

import java.io.RandomAccessFile;

public class CopyDemo2 {
	public static void main(String[] args) {
		try {
			RandomAccessFile raf 
			= new RandomAccessFile("music.mp3", "r"
					);
			RandomAccessFile raf_cp 
			= new RandomAccessFile("music_cp.mp3", "rw"
					);
			byte[] buff = new byte[1024*10];
			int len = -1;
			long end = System.currentTimeMillis();
			while((len = raf.read(buff))!= -1) {
				
				raf_cp.write(buff, 0, len);
			}
			
			System.out.println(
					"复制成功!耗时："+(System.currentTimeMillis()-end)+"ms"
					);
			
			raf.close();
			raf_cp.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
