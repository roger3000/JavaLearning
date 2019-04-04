package day04;
/**
 * 泛型的原型是Object
 * 定义了泛型只是编译期在做一些验证工作
 * 当我们对泛型类型设置值时 会检查是否满足类型要求
 * 当我们获取一个泛型类型的值时 会自动进行类型转换
 * @author Administrator
 *
 */
public class PointTest02 {
	public static void main(String[] args) {
		/*
		 * 这里指定泛型类型为Integer
		 * 但实际上 创建的Point对象中 xy属性是
		 * Object类型 
		 * 这里只是应当将它当作Integer来看待
		 * Integer类似加了一扇门
		 */
		Point<Integer> p1 = new Point<Integer>(1, 2);
		/*
		 * 由于参数是T 这里会验证实参是否为Integer
		 * 若不是 编译失败
		 * 可以传入基本类型 因为还会自动装箱
		 */
		p1.setX(1);
		/*	
		 * Integer -> int
		 * 获取时 也会自动造型 这里无需显式的进行
		 * 类型转换
		 */
		int x1 = p1.getX();
		/*
		 * 若不指定泛型 则默认使用Object类型
		 */
		Point p2 = p1;
		p2.setX("yi");
		
		System.out.println(p2.getX());
		//这里会报错 类型转换异常
		//String -> int
		x1 = p1.getX();
		System.out.println(x1);
	}
}
