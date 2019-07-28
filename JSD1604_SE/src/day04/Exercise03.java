package day04;

import java.util.ArrayList;
import java.util.List;

public class Exercise03 {
	public static void main(String[] args) {
		/*
		 * 创建一个List集合
		 * 存放one two three four
		 * 获取集合第二个元素并输出
		 * 将集合第三个元素设置为3
		 * 再集合第二个位置上插入元素2
		 * 删除集合第三个元素
		 */
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		
		System.out.println(list.get(1));
		
		list.set(2, "3");
		System.out.println(list);
		
		list.add(1, "2");
		System.out.println(list);
		
		list.remove(2);
		System.out.println(list);
	}
}
