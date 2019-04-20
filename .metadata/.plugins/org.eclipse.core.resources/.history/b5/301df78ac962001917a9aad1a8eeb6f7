package day03;

import java.io.RandomAccessFile;

public class CopyDemo1 {
	public static void main(String[] args) {
		try {
			RandomAccessFile src
			= new RandomAccessFile("test.png", "r"
					);
			RandomAccessFile desc
			= new RandomAccessFile("test_cp.png", "rw"
					);
			int d = -1; //用于保存读取到的每个字节
			
			while((d = src.read())!=-1) {
				desc.write(d);
			}
			
			System.out.println("复制完毕");
			
			src.close();
			desc.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
