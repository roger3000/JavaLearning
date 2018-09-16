package day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合转换为数组
 * @author Administrator
 *
 */
public class CollectionToArrayDemo {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<>();
		
		for(int i=0; i<10; i++){
			c.add(new Integer(i).toString());
		}
		
		System.out.println(c);
		
		/*
		 * 集合提供了一个方法toArray, 可以将
		 * 当前集合转换为数组
		 */
		
//		Object[] array = c.toArray();
		
		/*
		 * 若给定的数组可用(数组可以存放集合所有元素)时
		 * 则使用该数组, 若不可用, 会自动创建一个与给定
		 * 数组同类型的数组
		 */
		String[] array = c.toArray(new String[c.size()]);
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(i+" ");
		}
	}
}
