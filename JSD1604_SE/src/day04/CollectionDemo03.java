package day04;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * 遍历集合
 * Collection提供了同意的遍历集合元素的方式
 * 迭代器
 * Iterator iterator()
 * 获取用于遍历当前集合的迭代器
 * 
 * java.util.Iterator是一个接口, 规定了用于遍历集合元素的相关方法
 * 不同的集合提供了相应的实现类
 * 无需记住那些实现类的名字, 只将他们当作iterator即可
 * 
 * 遍历集合遵循:问, 取, 删的步骤, 其中删除不是必须操作
 * @author Administrator
 *
 */
public class CollectionDemo03 {
	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("one");
		c.add("#");
		c.add("two");
		c.add("#");
		c.add("three");
		c.add("#");
		c.add("four");
		//获取用于遍历当前集合的迭代器
		Iterator iter = c.iterator();
		/*
		 * boolean hasNext() 问的过程
		 * 该方法是判断集合中是否还有元素可以取出
		 * 
		 * E next() 取的过程
		 * 获取集合中下一个元素
		 */
		while (iter.hasNext()) {
			String str = (String)iter.next();
			if("#".equals(str)){
				/*
				 * 在使用迭代器遍历集合时, 不要
				 * 使用集合的方法增删元素, 否则
				 * 会引发异常
				 * 可以使用迭代器本身的remove方法
				 */
//				c.remove(str);
				iter.remove();
			}
			System.out.println(str);
		}
		System.out.println(c);
	}
}
