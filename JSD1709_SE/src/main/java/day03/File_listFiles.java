package day03;

import java.io.File;
import java.util.Arrays;

public class File_listFiles {
	public static void main(String[] args) {
		File dir = new File(".");
		//判断是否目录
		if(dir.isDirectory()) {
			/*
			 *获取所有子项
			 *File[] listFiles() 
			 */
			File[] files = dir.listFiles();
			System.out.println(Arrays.toString(files));
		}else {
			System.out.println("不是目录!");
		}
	}
}
