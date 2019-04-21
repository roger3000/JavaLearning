package day03;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile_read {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("./demo.txt", "rw");
		int d = raf.read();
		System.out.println(d);
		raf.close();
	}
}
