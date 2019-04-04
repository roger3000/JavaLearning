package day02;

import java.util.Scanner;

public class Exercise {
	public static void main(String[] args) {
		/*
		 * 输出一个字符串, 然后若该字符串是一个整数, 则转换为整数后输出乘以10后的结果
		 * 若是小数, 则转换为一个小数后输出乘以5后的结果,若不是数字则输出"不是数字"
		 * 需要使用正则表达式进行判断
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入:");
		String str = scan.nextLine();
		String regex = "\\d+";
		String regex1 = "\\d+.\\d+";
		if(str.matches(regex)){
			System.out.println(Integer.valueOf(str)*10);
		}else if(str.matches(regex1)){
			System.out.println(Double.valueOf(str)*5);
		}else{
			System.out.println("不是数字");
		}
		
		/*
		 * 将字符串123,456,789,012根据","拆分, 并输出拆分后的每一项
		 */
		String str2 = "123,456,789,012";
		String[] strArr = str2.split(",");
		for(String s : strArr){
			System.out.print(s+" ");
		}
		System.out.println();
		/*
		 * 将字符串123abc456def789ghi中的英文部分替换为"#char#"
		 */
		String str3 = "123abc456def789ghi";
		String regex3 = "[a-zA-z]+";
		System.out.println(str3.replaceAll(regex3, "#char#"));
		scan.close();
		
	}
}
