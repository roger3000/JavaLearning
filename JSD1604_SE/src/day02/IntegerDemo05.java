package day02;
/**
 * jdk1.5之后推出了一个新特性
 * 自动拆装箱
 * 编译期间 会自动在int-Integer之间转换
 * @author Administrator
 *
 */
public class IntegerDemo05 {
	public static void main(String[] args) {
		Integer i = Integer.valueOf(1);
		//基本类型接收了引用类型?-----自动拆装箱
		//自动补上了.intValue
		int i2 = new Integer(10);
		//自动补上了Integer.valueOf(1234)
		Integer i3 = 1234;
	}
}
