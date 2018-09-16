package day02;

import java.util.Scanner;

/**
 * 测试正则表达式
 * 字符串支持正则表达式的方法一:
 * boolean matches(String regex)
 * 根据给定的正则表达式验证但钱字符串是否满足格式
 * 要求,满足这返回true, 否则返回false
 * @author Administrator
 *
 */
public class StringDemo01 {
	/**
	 * 正则表达式中:
	 * [] \d \w \s表示输入的值的范围
	 * []中的 . 表示任意值 \.==.
	 * {} + * ?表示数量
	 * ()表示分组
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入邮箱");
		String str = scan.nextLine();
		//String 中\\ == \
//		String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9]+)+";
		String regex = "[\\w\\d_]+@[\\w\\d_]+(\\.[\\w\\d_]+)+";
		System.out.println(str.matches(regex));
		System.out.println("请输入密码:");
		String str2 = scan.nextLine();
		String regex2 = "[A-Z][\\d\\w_]+";
		System.out.println(str2.matches(regex2));
		scan.close();
	}
}
