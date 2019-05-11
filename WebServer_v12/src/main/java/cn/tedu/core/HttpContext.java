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

	/**
	 * 正常
	 */
	public static final int STATUS_CODE_OK = 200;
	/**
	 * 未找到
	 */
	public static final int STATUS_CODE_NOE_FOUND = 404;
	/**
	 * 错误
	 */
	public static final int STATUS_CODE_ERROR = 500;

	/**
	 * 状态码与描述的映射
	 */
	private static Map<Integer, String> code_reason_mapping;

	/**
	 * 介质类型映射 key:介质类型 value:Content-type对应该类型的值
	 */
	private static Map<String, String> map;

	static {
		init();
	}

	private static void init() {
		initMineMap();
		initCodeReasonMapping();
	}

	/**
	 * 初始化状态代码与描述的映射
	 */
	private static void initCodeReasonMapping() {
		code_reason_mapping = new HashMap<Integer, String>();
		code_reason_mapping.put(STATUS_CODE_OK, "OK");
		code_reason_mapping.put(STATUS_CODE_NOE_FOUND, "NOT FOUND");
		code_reason_mapping.put(STATUS_CODE_ERROR, "ERROR");
	}

	/**
	 * 初始化介质类型映射
	 */
	private static void initMineMap() {
		map = new HashMap<String, String>();
		try {
			SAXReader reader = new SAXReader();
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

	/**
	 * 获取给定的状态代码的状态描述
	 * 
	 * @param code
	 * @return
	 */
	public static String getCode_reason_mapping(int code) {
		return code_reason_mapping.get(code);
	}

}
