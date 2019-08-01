package day07;

import java.util.Arrays;
import java.util.List;

public class ArraysToListDemo {
	public static void main(String[] args) {
		String[] str = {"one","two","three"};
		
		List<String> list = Arrays.asList(str);
		
		list.set(1, "2");
		
		System.out.println(Arrays.toString(str));
		
		System.out.println(list);
	}
}
