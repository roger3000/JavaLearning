package day09;

import java.util.HashMap;
import java.util.Map;

public class Map_contains {
	public static void main(String[] args) {
		Map<String, Integer> map = 
				new HashMap<String , Integer>();
		
		map.put("语文", 99);
		map.put("数学", 100);
		
		System.out.println(map.containsKey("语文"));
		System.out.println(map.containsValue(99));
	}
}
