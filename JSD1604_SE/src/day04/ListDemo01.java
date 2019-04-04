package day04;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.List
 * 可重复集合 并且有序
 * 特点是可以更具下标操作元素
 * 常用实现类:
 * ArrayList:使用数组实现 查询更快
 * LinkedList: 使用链表实现 增删更快 (头尾效果更好)
 * @author Administrator
 *
 */
public class ListDemo01 {
	public static void main(String[] args) {
		/*
		 * E set(int index, E e)
		 * 将给定元素设置道指定位置上 返回值为
		 * 原位置的元素 所以是替换元素操作
		 */
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		System.out.println(list);
		//本质 替换
		String pop = list.set(1, "2");
		System.out.println(list);
		System.out.println(pop);
		//add(int index, E e)
		list.add(4, "five");
		System.out.println(list);
		
		//E get(int index)
		System.out.println(list.get(3));
		
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
		
	}
}
