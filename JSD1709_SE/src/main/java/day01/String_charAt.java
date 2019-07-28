package day01;

public class String_charAt {
	public static void main(String[] args) {
		String str = "thinking in java";
		System.out.println(str.charAt(4));
		
		/**
		 * 检测回文
		 * 上海自来水来自海上
		 * 哥曾信佛但佛曾信曾哥
		 */
		String info = "哥曾信佛但佛1信曾哥";
		//正数位置的字符与倒数位置的字符都一样
		for (int i = 0; i < info.length()/2; i++) {
			char c1 = info.charAt(i);
			char c2 = info.charAt(info.length()-1-i);
			System.out.println(c1);
			System.out.println(c2);
			System.out.println("=========");
		}
		checkString(info);
	}
	
	//回文检测
	public static void checkString(String str) {
		boolean tf = true;
		for (int i = 0; i < str.length()/2; i++) {
			char c1 = str.charAt(i);
			char c2 = str.charAt(str.length()-i-1);
			if(c1 != c2) {
				System.out.println("不是回文");
				tf = false;
				return;
			}
		}
		if(tf) {
			System.out.println("是回文");
		}
	}
}
