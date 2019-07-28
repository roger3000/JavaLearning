package day02;
/**
 * 测试重写Object相关方法
 * @author Administrator
 *
 */
public class TestPoint {
	public static void main(String[] args) {
		Point p1 = new Point(1, 2);
		/*
		 * 直接print对象时 会自动调用toString()
		 */
		System.out.println(p1);
		Point p2 = new Point(1, 2);
		System.out.println(p1.equals(p2));
	}
}
