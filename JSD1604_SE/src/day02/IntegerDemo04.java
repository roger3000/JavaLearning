package day02;
/**
 * 包装类提供了一个静态方法parseXXX(String str)
 * 可以将给定的字符串转换为对应的基本类型
 * 前提是该字符串必须正确的描述基本类型可以保存的值
 * @author Administrator
 *
 */
public class IntegerDemo04 {
	public static void main(String[] args) {
		String str = "123243";
		System.out.println(Integer.parseInt(str)+1);
		
		System.out.println(Double.parseDouble("12343.123"));
	}
}
