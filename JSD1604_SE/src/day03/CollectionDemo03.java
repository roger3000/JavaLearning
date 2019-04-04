package day03;

import java.util.Collection;
import java.util.ArrayList;

import day02.Point;

/**
 * 集合存放元素存放的是引用(地址)
 * @author Administrator
 *
 */
public class CollectionDemo03 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		Point p = new Point(1, 2);
		c.add(p);
		System.out.println(c);
		p.setX(2);
		//证明集合存的是引用
		System.out.println(c);
	}
}
