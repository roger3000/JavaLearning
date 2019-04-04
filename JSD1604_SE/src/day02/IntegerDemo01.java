package day02;

public class IntegerDemo01 {
	public static void main(String[] args) {
		dosome("abc");
		/*
		 * jdk1.4在此会报错
		 * 因为基本类型不是object的子类
		 * byte int short long char double float boolean 8个基本类型
		 * 是以值的形式直接存在的(栈内存), 所以他们并没有面向对象的特性, 自然也不能继承Object.所以
		 * 不能使用多态, 用Object的角度去接受基本类型 
		 * 为了能以面向对象的方法去使用基本类型 所以就有了包装类
		 * Integer Character 等
		 */
		Integer i = new Integer(10);
		dosome(1);
		dosome(new Point());
	}
	
	public static void dosome(Object obj){
		
	}
}
