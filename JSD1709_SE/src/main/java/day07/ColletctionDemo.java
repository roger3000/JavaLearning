package day07;

import java.util.ArrayList;
import java.util.Collection;

public class ColletctionDemo {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("two");
		c.add("three");
		
		System.out.println(c);
		System.out.println(c.size());
		System.out.println(c.isEmpty());
		
	}
}
