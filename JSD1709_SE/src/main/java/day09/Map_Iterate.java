package day09;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 遍历map
 * @author HNL
 *
 */
public class Map_Iterate {
	public static void main(String[] args) {
		Map<String, Integer> map = 
				new HashMap<String , Integer>();
		
		map.put("语文", 99);
		map.put("数学", 100);
		map.put("英语", 98);
		map.put("物理", 91);
		map.put("化学", 99);
		map.put("生物", 57);
		//遍历所有key
		Set<String> set = map.keySet();
		System.out.println(set);
		for(String k : set) {
			System.out.println(k);
		}
		
		//遍历所有k-v
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		
		for(Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
		//遍历所有value
		Collection<Integer> c = map.values();
		for(Integer i : c) {
			System.out.println(i);
		}
		
	}
}
