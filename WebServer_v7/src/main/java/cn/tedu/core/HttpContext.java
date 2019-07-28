package cn.tedu.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

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
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new FileInputStream("web.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.elements("mime-mapping");
			
			for (Element element : list) {
				String key = element.elementText("extension");
				String value = element.elementText("mime-type");
				
				map.put(key, value);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getMineMap(String key) {
		return map.get(key);
	}
	
	
	
}
