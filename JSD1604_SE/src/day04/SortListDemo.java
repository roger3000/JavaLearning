package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 排序集合元素
 * 排序集合使用的是集合的工具类Collection的
 * 静态方法sort
 * 排序仅能对List集合进行 因为Set大部分都是无序的
 * @author Administrator
 *
 */
public class SortListDemo {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Random rand = new Random();
		for(int i=0; i<10; i++){
			list.add(rand.nextInt(100));
		}
		Collections.sort(list);
		System.out.println(list);
	}
}
