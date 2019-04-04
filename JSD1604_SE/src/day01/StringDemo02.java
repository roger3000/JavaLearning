package day01;
/**
 * 
 * @author Administrator
 *
 */
public class StringDemo02 {
	public static void main(String[] args) {
		//            0123456789012
		String str = "thinking in java";
		int index = str.indexOf("in");
		System.out.println(index);
		
		index = str.indexOf("in", 3);
		System.out.println("index:"+index);
		
		index = str.lastIndexOf("in");
		System.out.println(index);
		
		String str2 = str.substring(3);
		System.out.println(str2);
		/**
		 * java api 有个特点 用两个数字表示范围的时候 通常含头 不含尾
		 */
		str2 = str.substring(0, 8);
		System.out.println(str2);
	}
}
