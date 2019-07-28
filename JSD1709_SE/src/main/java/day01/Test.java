package day01;

public class Test {
	public static void main(String[] args) {
		String str = getHostName("www.oracle.com");
		System.out.println(str);
		
		str = getHostName("http://www.baidu.com");
		System.out.println(str);
		
		str = getHostName("http://www.tedu.com.cn");
		System.out.println(str);
	}
	
	public static String getHostName(String url) {
		/**
		 * 截取地址中 第一个点和第二个点之间的内容
		 */
		int index = url.indexOf(".");
		int endIndex = url.indexOf(".",index+1);
		String result = url.substring(index+1, endIndex);
		return result;
	}
}
