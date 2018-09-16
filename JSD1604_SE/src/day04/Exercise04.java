package day04;

import java.util.ArrayList;
import java.util.List;

public class Exercise04 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<10; i++){
			list.add(i);
		}
		System.out.println(list);
		
		List<Integer> subList = list.subList(3, 7);
		System.out.println(subList);
		
		for(int i=0; i<subList.size(); i++){
			subList.set(i, subList.get(i)*10);
		}
		System.out.println(list);
		
		subList = list.subList(7, 10);
		subList.clear();
		System.out.println(list);
	}
}
