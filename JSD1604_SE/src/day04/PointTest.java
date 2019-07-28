package day04;

public class PointTest {
	public static void main(String[] args) {
		//泛型只能使用包装类
		Point<Integer> p1 = new Point<Integer>(1, 2);
		Point<String> p2 = new Point<String>("一", "二");
		Point<Double> p3 = new Point<Double>(1.0, 2.0);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}
}
