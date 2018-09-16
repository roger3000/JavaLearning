package day02;
/**
 * 图片重命名
 * @author Administrator
 *
 */
public class Test02 {
	public static void main(String[] args) {
		String picName = "1.jpg";
		String[] names = picName.split("\\.");
		picName = System.currentTimeMillis()+"."+names[1];
		System.out.println(picName);
	}
}
