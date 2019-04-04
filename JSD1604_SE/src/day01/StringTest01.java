package day01;

import java.util.Scanner;

public class StringTest01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入网址");
		String url = scan.nextLine();
		int start = url.indexOf("www")+4;
		int end = url.lastIndexOf(".com");
		String domain = url.substring(start, end);
		System.out.println(domain);
		scan.close();
	}
}
