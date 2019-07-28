package cn.tedu.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ServletContext {
	private static Map<String, String > servletMapping;
	
	private static void initServletMapping() {
		servletMapping = new HashMap<String, String>();
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read("/conf/ServletMapping.xml");
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
			for (Element element : list) {
				String uri = element.attributeValue("uri");
				String className = element.attributeValue("className");
				servletMapping.put(uri, className);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
