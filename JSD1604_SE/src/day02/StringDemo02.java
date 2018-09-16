package day02;

import java.util.Scanner;

/**
 * 字符串支持正则表达式方法二
 * String[] split(String regex)
 * 将当前字符串按照满足正则表达式的部分进行拆分
 * 返回拆分后的每段内容
 * @author Administrator
 *
 */
public class StringDemo02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		String regex = "[0-9]+";
		String[] strA = str.split(regex);
		/**
		 * 输入qwe123qwe45qwe67
		 * 输出 qwe qwe qwe
		 */
		for(String s : strA){
			System.out.println(s);
		}
		scan.close();
	}
}
