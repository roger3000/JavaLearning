package cn.tedu.http;

import java.util.HashMap;
import java.util.Map;

public class HttpContext {
	public static final int CR = 13;
	public static final int LF = 10;
	
	private static Map<String, String> map = 
			new HashMap<String, String>();
	
	static {
		init();
	}
	
	private static void init() {
		initMineMap();
	}
	
	private static void initMineMap() {
		map.put("html", "text/html");
		map.put("png", "image/png");
		map.put("jpg", "image/jpg");
		map.put("gif", "image/gif");
	}

	public static String getMineMap(String key) {
		return map.get(key);
	}
	
	
	
}
