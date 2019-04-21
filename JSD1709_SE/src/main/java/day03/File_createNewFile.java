package day03;

import java.io.File;

/**
 * 使用File创建一个文件
 * @author xhquan
 *
 */
public class File_createNewFile {
	public static void main(String[] args) throws Exception {
		File file = new File(
				"."+File.separator+"test.txt"
				);
		if (!file.exists()) {
			file.createNewFile();
			System.out.println("文件创建完毕!");
		}else {
			System.out.println("文件已存在!");
		}
		
	}
}
