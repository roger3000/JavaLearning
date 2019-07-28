package day03;

import java.io.File;
import java.io.IOException;

public class Test {
	static {
		File dir = new File("./a/1b/c/d/e/f");
		if (!dir.exists()) {
			dir.mkdirs();
			System.out.println("文件夹创建成功");
			System.out.println("=========================");
		}
		File file2 = new File("./a/1b/test.txt");
		if (!file2.exists()) {
			try {
				file2.createNewFile();
				System.out.println(file2.getName()+"创建成功!");
				System.out.println("==============================");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		
		String pathname = "./a";
		File dir = new File(pathname);
		
		if (dir.exists() && dir.isDirectory()) {
			//递归调用delete()
			delete(dir);

		}else {
			System.out.println("folder is not exist");
		}
	}
	
	public static void delete(File file) {
		if(file.isDirectory()) {
			File[] subs = file.listFiles();
			for (int i = 0; i < subs.length; i++) {
				delete(subs[i]);
			}
		}else {
			file.delete();
			System.out.println(file.getName()+"删除成功");
		}
		
	}
}
