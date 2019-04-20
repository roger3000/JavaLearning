package day03;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class RandomAccessFile_writeInt {
	public static void main(String[] args) {
		try {
			RandomAccessFile raf
			= new RandomAccessFile(
					"type.dat", "rw"
					);
			int imax = Integer.MAX_VALUE;
			raf.write(imax>>>24); 		//imax右移24位
			raf.write(imax>>>16);
			raf.write(imax>>>8);
			raf.write(imax>>>4);
			
			System.out.println("写出成功");
			
			raf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
