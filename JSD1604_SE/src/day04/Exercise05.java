package day04;

import java.util.ArrayList;
import java.util.List;

public class Exercise05 {
	public static void main(String[] args) {
		/*
		 * 创建一个list集合 并添加元素0-9
		 * 将集合转换为一个Integer数组并输出数组每一个元素
		 */
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<10; i++){
			list.add(i);
		}
		System.out.println(list);
		
		Integer[] arr = list.toArray(new Integer[list.size()]);
		for(int i:arr){
			System.out.print(i+" ");
		}
	}
}
