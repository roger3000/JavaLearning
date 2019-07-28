package day01;

public class String_replaceAll {
	public static void main(String[] args) {
		String str = "abc4sdf445dsf45sd4f5sd445ds4";
		String regex = "\\d+";
		System.out.println(str.replaceAll(regex, "#NUMBER#"));
	}
}
