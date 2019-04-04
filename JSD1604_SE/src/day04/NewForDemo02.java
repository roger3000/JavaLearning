package day04;

import java.util.ArrayList;
import java.util.Collection;

public class NewForDemo02 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("two");
		c.add("three");
		/*
		 * 新循环并非新语法 新循环是编译器认可, 而不是虚拟机认可
		 * 使用新循环遍历集合是 编译器会将它改为迭代器方式遍历 
		 * 所以在使用新循环遍历集合时 不能通过集合的方法增删元素
		 */
		for(Object o:c){
			String str = (String)o;
			System.out.println(str);
		}
	}
}
