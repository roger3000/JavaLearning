package day02;
/**
 * 数字类型的包装类继承自Number
 * 其提供了如:intValue doubleValue这样的
 * 方法,作用是可以将当前包装类表示的数字以及其他
 * 数字类型的形式返回
 * @author Administrator
 *
 */
public class IntegerDemo02 {
	public static void main(String[] args) {
		/*
		 * 将基本类型转换为包装类有两种方式:
		 * 1.调用构造方法
		 * 2.使用静态方法valueOf(推荐)
		 * valueOf缓存了一个字节的有符号数 当在一个字节内时
		 * 可以重用
		 */
		Integer i1 = Integer.valueOf(-129);
		Integer i2 = Integer.valueOf(-129);
		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));
		
		//将integer还原成int等
		int i = i1.intValue();
		System.out.println(i);
		
		double d = i1.doubleValue();
		System.out.println(d);
		
		byte b = i1.byteValue();
		System.out.println(b);
	}
}
