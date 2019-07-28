package day01;

import java.util.Scanner;

public class String_rename {
	public static void main(String[] args) {
		String pic = "123.png";
		//按照"." 拆分
		String[] data = pic.split("\\.");
		pic = System.currentTimeMillis()+"."+data[1];
		
		System.out.println(pic);
		
		//使用stringbuilder 来拆分
		String regex = "\\.";
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入图片名称");
		sb.append(scanner.nextLine());
		String[] data1 = sb.toString().split(regex);
		sb.replace(0, sb.length(), System.currentTimeMillis()+"."+data1[1]);
		System.out.println(sb.toString());
		
		scanner.close();
	}
}
