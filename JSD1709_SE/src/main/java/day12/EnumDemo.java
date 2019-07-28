package day12;

public class EnumDemo {
	public static void main(String[] args) {
		for (Fruit f : Fruit.values()) {
			System.out.println(f.toString());
		}
	}
}
