package day01;

import java.util.Scanner;

/**
 * 字符串支持正则表达式的相关方法
 * boolean matcher(String regex)
 * 使用给定的正则表达式验证当前字符串是否满足该格式要求
 * 
 * JAVA中 正则表达式无论是否添加了边界符号(^&) 都是做全匹配(默认添加^&)
 * @author xhquan
 *
 */
public class String_matcher {
	public static void main(String[] args) {
		String str;
		//定义验证邮箱格式的正则表达式
		String regex = "\\w+@([\\.\\w]+)";
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("请输入邮箱");
			str = scanner.nextLine();
			//验证邮箱格式
			boolean flag = str.matches(regex);
			System.out.println(flag?"邮箱正确":"邮箱错误");
		}
	}
}
