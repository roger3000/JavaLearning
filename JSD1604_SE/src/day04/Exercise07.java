package day04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Exercise07 {
	public static void main(String[] args) {
		/*
		 * 创建一个List集合 并存放10个随机数 然后排序该集合后输出
		 */
		
		List<Integer> list = new ArrayList<>();
		Random rand = new Random();
		for(int i=0; i<10; i++){
			list.add(rand.nextInt(100));
		}
		
		Collections.sort(list);
		System.out.println(list);
	}
}
