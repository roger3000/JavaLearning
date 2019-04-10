package day03;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RAF专门用来读写数据
 * RAF基于指针对文件数据进行读写
 * @author xhquan
 *
 */
public class RandomAccessFile_write {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("./demo.txt", "rw"); 
		System.out.println(raf.readLine());
		raf.close();
	}
}
