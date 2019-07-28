package day01;
/**
 * static String valueOf(XXX xxx)
 * 该方法是将java中其他类型转化为字符串
 * @author Administrator
 *
 */
public class StringDemo06 {
	public static void main(String[] args) {
		int a = 123456;
		char[] b = {'a','b','c','d','e'};
		String str = String.valueOf(a);
		String str2 = String.valueOf(b);
		if(str instanceof String){
			System.out.println(str);
			System.out.println(str2);
		}
	}
}
