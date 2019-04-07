package day01;

public class String_startsWith_endSwith {
	public static void main(String[] args) {
		String str = "thinking in java";
		
		boolean starts = str.startsWith("thinking");
		System.out.println(starts);
		
		boolean ends = str.endsWith("java");
		System.out.println(ends);
	}
}
