package day03;

import java.util.ArrayList;
import java.util.Collection;

import day02.Point;

/**
 * java.util.Collection
 * 集合, 用于存储一组元素 提供了维护集合的相关操作
 * 其派生了两个子接口:
 * List: 可重复集合
 * Set: 不可重复集合
 * 元素是否重复是依靠自身equals方法比较的结果而定的
 * @author Administrator
 *
 */
public class CollectionDemo01 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		/*
		 * boolean add(E e)
		 * 向集合中添加元素
		 */
		
		c.add("a");
		c.add("b");
		c.add("c");
		
		System.out.println(c);
		
		/*
		 * int size()
		 * 返回当前集合的元素
		 */
		System.out.println(c.size());
		
		/*
		 * boolean isEmpty()
		 * 判断当前集合是否不含有任何元素
		 * 空集合
		 */
		System.out.println(new ArrayList().isEmpty());
		
		/*
		 * void clear()
		 * 清空集合
		 */
		c.clear();
		System.out.println(c.isEmpty());
	}	
}
