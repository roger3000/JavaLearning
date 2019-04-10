package day03;

import java.io.File;

/**
 * 使用File创建一个文件
 * @author xhquan
 *
 */
public class File_delete {
	public static void main(String[] args) {
		/*
		 * 将当前目录中的test.txt文件删除
		 */
		File file = new File("test.txt");
		if (file.exists()) {
			file.delete();
			System.out.println("文件已删除");
		}else {
			System.out.println("file is not found");
		}
	}
}
