package day09;

import java.util.HashMap;
import java.util.Map;

/**
 * java.util.map
 * Map 查找表
 * @author HNL
 *
 */
public class Map_get_put {
	public static void main(String[] args) {
		Map<String, Integer> map = 
				new HashMap<String, Integer>();
		
		map.put("语文", 99);
		map.put("数学", 100);
		map.put("英语", 98);
		
		System.out.println(map);
		
		System.out.println(map.get("语文"));
	}
}
