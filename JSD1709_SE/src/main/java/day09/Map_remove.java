package day09;

import java.util.HashMap;
import java.util.Map;

/**
 * 删除map中的元素
 * @author HNL
 *
 */
public class Map_remove {
	public static void main(String[] args) {
		Map<String, Integer> map = 
				new HashMap<String , Integer>();
		
		map.put("语文", 99);
		map.put("数学", 100);
		System.out.println(map);
		
		map.remove("数学");
		System.out.println(map);
	}
}
