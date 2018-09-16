package day03;

import java.util.Collection;
import java.util.ArrayList;

/**
 * 5.创建一个集合, 存放字符串"one" "two" "three"
 * 然后输出给集合的元素个数
 * 然后输出该集合是否包含字符串"four"
 * 然后输出集合是否不包含任何元素
 * 然后清空集合
 * 然后输出该集合的元素个数
 * 然后输出集合是否不含有任何元素
 * @author Administrator
 *
 */
public class Exercise02 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("two");
		c.add("three");
		
		//输出集合个数
		System.out.println(c.size());
		
		//是否包含字符串"four"
		System.out.println(c.contains("four"));
		
		//是否为空
		System.out.println(c.isEmpty());
		
		//清空集合
		c.clear();
		
		//输出个数
		System.out.println(c.size());
		
		//是否为空
		System.out.println(c.isEmpty());
		
	}
}
