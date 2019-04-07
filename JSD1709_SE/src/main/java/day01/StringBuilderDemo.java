package day01;

public class StringBuilderDemo {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			sb.append("a");
		}
		System.out.println(System.currentTimeMillis()-start);
		System.out.println("执行完毕");
	}
}
