package day04;
/**
 * jdk5.0之后退出了一个新的特性:
 * 增强型for循环, 又叫做新循环, for each
 * 
 * 新循环不能替代传统循环 作用仅仅时用来遍历集合或数组的
 * @author Administrator
 *
 */
public class NewForDemo {
	public static void main(String[] args) {
		String[] array = {"one", "two", "three", "five"};
		for(String s:array){
			System.out.println(s);
		}
	}
}
