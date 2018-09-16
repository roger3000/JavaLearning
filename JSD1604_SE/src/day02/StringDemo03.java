package day02;
/**
 * 字符串支持正则表达式方法三:
 * String replaceAll(String regex)
 * 将当前字符串中年满足正则表达式的部分替换为给定字符串
 * @author Administrator
 *
 */
public class StringDemo03 {
	public static void main(String[] args) {
		String str = "abc123def456ghi789";
		String regex = "[\\d]{3}";
		System.out.println(str.replaceAll(regex, "mother fucker"));
	}
}
