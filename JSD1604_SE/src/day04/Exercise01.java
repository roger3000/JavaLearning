package day04;

import java.util.ArrayList;
import java.util.List;

public class Exercise01 {
	public static void main(String[] args) {
		/*
		 * 创建一个集合c1, 存放元素one two three
		 * 再创建一个集合c2 存放元素 four five six
		 * 然后将c2元素全部存入c1集合
		 * 然后再创建集合c3 存放元素 one,five
		 * 然后输出集合c1 是否包含集合c3的所有元素
		 */
		
		List<String> c1 = new ArrayList<>();
		c1.add("one");
		c1.add("two");
		c1.add("three");
		List<String> c2 = new ArrayList<>();
		c2.add("four");
		c2.add("five");
		c2.add("six");
		c1.addAll(c2);
		List<String> c3 = new ArrayList<>();
		c3.add("one");
		c3.add("five");
		System.out.println(c1.containsAll(c3));
		c1.remove("two");
		System.out.println(c1);
	}
}
