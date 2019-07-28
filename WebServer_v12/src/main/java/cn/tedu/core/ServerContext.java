package cn.tedu.core;
/**
 * 服务端配置相关信息
 * @author HNL
 *
 */

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import servlets.LoginServlet;

public class ServerContext {
	public static Map<String, String> servletMapping;
	static {
		initServletMapping();
	}

	private static void initServletMapping() {
		servletMapping = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File("conf/ServletMapping.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
			for (Element ele : list) {
				String key = ele.attributeValue("uri");
				String value = ele.attributeValue("className");
				servletMapping.put(key, value);
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
