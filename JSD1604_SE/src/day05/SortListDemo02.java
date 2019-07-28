package day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo02 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("苍老师");
		list.add("小泽老师");
		list.add("许老师");
		
		System.out.println(list);
		/*
		 * 重载的sort()方法要求传入一个额外的比较器
		 * 改方法不在要求必须实现Comparable接口
		 * 而是根据给定的这个额外的比较器的比较规则对集合进行排序
		 * 实际开发中也推荐使用这种方式排序集合元素
		 * 若集合元素是自定义的
		 * 创建比较器是也推荐使用匿名内部类的形式
		 */
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int result = o1.length()-o2.length();
				return result;
			}
			
		});
		System.out.println(list);
 	}
}

class MyComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o1.length()-o2.length();
	}
	
}
