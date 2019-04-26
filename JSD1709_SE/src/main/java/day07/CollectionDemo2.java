package day07;

import java.util.ArrayList;
import java.util.Collection;

import day01.Point;

public class CollectionDemo2 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Point p = new Point(1,2);
		Collection c = new ArrayList();
		
		c.add(p);
		
		System.out.println(p);
		System.out.println(c);
		
		p.setX(2);
		System.out.println(p);
		System.out.println(c);
		
		Point p2 = new Point(2, 2);
		
		assert c.contains(p2);
	}
}
