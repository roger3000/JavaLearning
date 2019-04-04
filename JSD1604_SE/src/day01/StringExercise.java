package day01;

public class StringExercise {
	public static void main(String[] args) {
		String str = "HelloWorld";
		//输出字符串的长度
		System.out.println(str.length());
		//输出o的位置
		System.out.println(str.indexOf('o'));
		//从下标5开始输出o的位置
		System.out.println(str.indexOf('o', 5));
		//截取hello 并输出
		System.out.println(str.substring(0, str.indexOf("World")));
		//截取world
		System.out.println(str.substring(str.indexOf("W"), str.indexOf("d")+1));
		//将"   Hello    "中两边去空白后输出
		System.out.println("    Hello    ".trim());
		//输出第六个字符
		System.out.println(str.charAt(6));
		//检测开头是否是 h 结尾是否是ld
		System.out.println(str.startsWith("h")+","+str.endsWith("ld"));
		//将字符全部转换为大写 和全小写
		System.out.println(str.toUpperCase());
		System.out.println(str.toLowerCase());
	}
}
