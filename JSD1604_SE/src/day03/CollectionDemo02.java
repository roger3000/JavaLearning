package day03;

import java.util.Collection;
import java.util.ArrayList;

import day02.Point;
/**
 * boolean contains(E e)
 * 判断当前集合是否包含给定元素
 * @author Administrator
 *
 */
public class CollectionDemo02 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1,2));
		c.add(new Point(3,4));
		c.add(new Point(5,6));
		System.out.println(c);
		//很明显 调用的是equals()
		System.out.println(c.contains(new Point(1,2)));
	}
}
