package day02;
/**
 * replaceAll实现和谐用语
 * @author Administrator
 *
 */
public class Test04 {
	public static void main(String[] args) {
		String regex =
				"(wqnmlgb|cnm|sb|djb|2b|tmd)";
		String message =
				"wqnmlgb!你个djb!你怎么这么sb!cnm!tmd!";
		message = message.replaceAll(regex, "***");
		System.out.println(message);
	}
}
