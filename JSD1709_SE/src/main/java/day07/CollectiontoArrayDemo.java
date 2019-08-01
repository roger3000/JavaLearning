package day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class CollectiontoArrayDemo {
	public static void main(String[] args) {
		ArrayList<String> as = new ArrayList<String>();
		
		as.add("one");
		as.add("two");
		as.add("three");
		as.add("four");
		
		String[] str = 
				as.toArray(new String[as.size()]);
		
		for(String s : as) {
			System.out.println(s);
		}
		
		System.out.println(Arrays.toString(str));
		
	}
}
