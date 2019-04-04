package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * List集合提供了一堆重载的add, remove方法
 * void add(int index, E e)
 * 将给定元素插入道指定位置
 * 
 * E remove(int index)
 * 从集合中删除指定位置的元素 并返回
 * @author Administrator
 *
 */
public class ListDemo02 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		
		list.add(4, "five");
		System.out.println(list);
		
		String str = list.remove(4);
		System.out.println(list);
		System.out.println(str);
	}
}
