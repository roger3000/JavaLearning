package day01;

public class StringDemo03 {
	public static void main(String[] args) {
		String str = "good good study day day up";
		char c = str.charAt(6);
		System.out.println(c);
		
		/**
		 * 检查一个字符串是否回文串
		 */
		String info = "aertytrea";
		for(int i=0; i < info.length()/2; i++){
			if(info.charAt(i) != info.charAt(info.length()-i-1)){
				System.out.println("不是回文");
				return;
			}
		}
		System.out.println("是回文");

	}
}
