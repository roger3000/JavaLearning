package day01;
/**
 * String substring(int start,int end)
 * 截取字符串，从start处开始街区到end（不含end）
 * 
 * java API有一个特点，通常有两个数字表示范围的时候都是含头不含尾的
 * @author xhquan
 *
 */
public class String_subString {
	public static void main(String[] args) {
		String str = "www.oracle.com";
		System.out.println(str.substring(4, 10));
		//从指定位置截取到末尾
		System.out.println(str.substring(4));
	}
}
