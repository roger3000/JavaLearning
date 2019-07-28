package day01;
/**
 * int indexOf()
 * 查找字符的位置
 * @author xhquan
 *
 */
public class String_indexOf {
	public static void main(String[] args) {
		//            0123456789012345
		String str = "thinging in java";
		//从头开始找
		System.out.println(str.indexOf("i"));
		//从指定位置开始找
		System.out.println(str.indexOf("in", 3));
		//查找最后一次出现的位置
		System.out.println(str.lastIndexOf("in"));
	}
}
