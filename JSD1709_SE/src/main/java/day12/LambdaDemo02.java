package day12;

import java.io.File;
import java.io.FileFilter;

public class LambdaDemo02 {
	public static void main(String[] args) {
		Runnable r = () -> {
			System.out.println("hello world");
		};

		Thread t = new Thread(r);
		t.start();

		Thread t1 = new Thread(() -> {
			System.out.println("HELLO WORLD");
		});

		t1.start();

		// 利用lambda实现FileFilter接口
		FileFilter txtFile = file -> {
			return file.getName().endsWith(".txt");
		};
		File dir = new File("D:/");
		File[] files = dir.listFiles(txtFile);
		for (File file2 : files) {
			System.out.println(file2);
		}
	}
}
