package day02;
/**
 * 使用replaceAll实现图片重命名
 * @author Administrator
 *
 */
public class Test03 {
	public static void main(String[] args) {
		String name = "daf.jpg";
		String regex = ".+\\.";
		System.out.println(name.replaceAll(regex, System.currentTimeMillis()+"."));
	}
}
