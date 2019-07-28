package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为集合
 * 需要注意, 转换只能转换为List集合
 * 使用的时数组的工具类Arrays的静态方法asList
 * 只能转换为List集合的主要原因时:Set不能存放重复元素
 * 所以若转换为Set集合可能出现丢失元素的情况
 * @author Administrator
 *
 */
public class ArrayToListDemo {
	public static void main(String[] args) {
		String[] strArr = {"one", "two", "three", "four"};
		
		List<String> list = Arrays.asList(strArr);
		System.out.println(list);
		
		/*
		 * 向集合中添加一个元素
		 * 
		 * 实际上下面的代码会抛出异常 原因在于 该集合是由数组转换过来的 
		 * 那么该集合就表示原来的数组 所以对集合的操作就是对数组的操作 
		 * 那么添加元素会导致原数组扩容 那么就不能表示原来的数组了
		 * 所以不允许向该集合添加新元素
		 */
//		list.add(4, "five");
//		System.out.println(list);
		
		//修改集合元素 数组元素也会改变
		list.set(1, "2");
		System.out.println(list);
		
		for(String s:strArr){
			System.out.println(s);
		}
		
		/*
		 * 若希望增删元素 需要另创建一个集合
		 */
//		List<String> list1 = new ArrayList<>();
//		list1.addAll(list);
		//使用复制构造器
		List<String> list1 = new ArrayList<>(list);
		list1.add("five");
		System.out.println(list1);
	}
}
