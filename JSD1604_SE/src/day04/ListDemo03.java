package day04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 取子集
 * List subList(int start, int end)
 * 获取当前集合中指定范围内的子集 同样含头不含尾
 * @author Administrator
 *
 */
public class ListDemo03 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<10; i++){
			list.add(i);
		}
		
		List<Integer> subList = list.subList(2, 8);
		System.out.println(subList);
		
		//将子集每个元素扩大10倍
		for(int i=0; i<subList.size(); i++){
			subList.set(i, subList.get(i)*10);
		}
		System.out.println(subList);
		//子集居然是引用!!!
		System.out.println(list);
		
		/*
		 * 删除集合中2-8的元素
		 */
		list.subList(2, 9).clear();
		System.out.println(list);
	}
}
