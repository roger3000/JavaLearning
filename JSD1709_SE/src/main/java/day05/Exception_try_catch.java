package day05;

public class Exception_try_catch {
	public static void main(String[] args) {
		System.out.println("程序开始了");
		try {
			String str = null;
			System.out.println(str);
		} catch (NullPointerException e) {
			e.printStackTrace(System.out);;
		}
	}
}
