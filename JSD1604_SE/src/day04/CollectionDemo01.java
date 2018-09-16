package day04;

import java.util.ArrayList;
import java.util.Collection;

import day02.Point;
/**
 * 删除集合元素
 * 
 * @author Administrator
 *
 */
public class CollectionDemo01 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add(new Point(1, 2));
		c.add(new Point(3, 4));
		c.add(new Point(5, 6));
		System.out.println(c);
		
		Point p = new Point(1, 2);
		//此处调用了equals()
		c.remove(p);
		System.out.println(c);
	}
}
