package day01;

public class StringDemo02 {
	public static void main(String[] args) {
		String str = "a";
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			str = str+'a';
		}
		long end = System.currentTimeMillis();
		System.out.println("运行完了"+(end - start));
	}
}
