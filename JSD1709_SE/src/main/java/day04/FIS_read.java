package day04;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * java.io.FileInputStream
 * 文件输入流
 * 文件流是节点流
 * 用于从文件中读取字节
 * @author lifer
 *
 */
public class FIS_read {
	public static void main(String[] args) throws IOException {
		FileInputStream fis =
				new FileInputStream("fos.txt");
		
		byte[] data = new byte[100];
		fis.read(data);
		System.out.println(

		);
		System.out.println(new String(data,"UTF-8"));
		fis.close();
	}
}
