package day04;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合的批量操作
 * @author Administrator
 *
 */
public class CollectionDemo02 {
	public static void main(String[] args) {
		Collection c = new ArrayList(); 
		c.add("java");
		c.add("c++");
		c.add(".net");
		System.out.println(c);
		
		Collection c2 = new ArrayList();
		c2.add("ios");
		c2.add("android");
		c2.add("linux");
		System.out.println(c2);
		
		/*
		 * 取并集
		 * boolean addAll(c2)
		 */
		
		c.addAll(c2);
		System.out.println(c);
		
		Collection c3 = new ArrayList();
		c3.add("java");
		c3.add("android");
		/*
		 * boolean containsAll(Collection c)
		 * 判断当前集合是否包含给定集合中的所有内容
		 */
		System.out.println(c.containsAll(c3));
		
		/*
		 * 从c集合中删除所有共有元素
		 * removeAll(Collection c)
		 */
		c.removeAll(c3);
		System.out.println(c);
	}
}
