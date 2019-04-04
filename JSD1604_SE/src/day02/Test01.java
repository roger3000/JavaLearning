package day02;

import java.util.Scanner;

/**
 * 验证手机号的正则表达式
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入手机号:");
		String str = scan.nextLine();
		String regex = "1[\\d]{10}";
		System.out.println(str.matches(regex));
		scan.close();
	}
}
