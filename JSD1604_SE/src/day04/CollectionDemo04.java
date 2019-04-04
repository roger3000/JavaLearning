package day04;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * 集合支持泛型 而泛型是用来约束集合中元素的类型
 * @author Administrator
 *
 */
public class CollectionDemo04 {
	public static void main(String[] args) {
		/*
		 * Collection<String>中的泛型
		 * 会对c 点出来的东西进行验证
		 * 
		 * ArrayList<String>中的泛型
		 * 是告诉对象 泛型的类型
		 * 以便向上造型
		 */
		Collection<String> c = new ArrayList<String>();
		
		//只能添加String类型的元素了
		c.add("one");
		c.add("two");
		c.add("three");
		
		for(String str:c){
			System.out.println(str);
		}
		
		Iterator<String> itr = c.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}
