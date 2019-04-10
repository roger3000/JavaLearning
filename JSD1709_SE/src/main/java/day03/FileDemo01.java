package day03;

import java.io.File;
import java.io.IOException;

/**
 * java.io.File
 * file 用于表示操作系统中文件系统里的一个文件或目录
 * 使用File可以
 * 查看该文件或目录的属性信息
 * 操作文件或目录
 * 访问一个目录的子项
 * 但是不能使用File访问文件的数据
 * @author xhquan
 *
 */
public class FileDemo01 {
	public static void main(String[] args) throws IOException {
		File file = new File(
				"."+File.separator+"demo.txt"
				);
		System.out.println(file.getName());
		
		System.out.println(file.length());

		System.out.println(file.canExecute());
		System.out.println(file.canWrite());
		System.out.println(file.canRead());
		System.out.println(file.isHidden());
		
		System.out.println(file.getCanonicalPath());
	}
}

