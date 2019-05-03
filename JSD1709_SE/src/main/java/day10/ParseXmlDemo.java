package day10;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ParseXmlDemo {
	public static void main(String[] args) {
		/*
		 * 解析xml的大致步骤
		 * 1 创建SAXReader
		 * 2使用SAXReader读取XML文档并生成 Document对象
		 * 	这一步就是DOM解析耗时耗资源的地方
		 * 3通过document获取根元素
		 */
		
		List<Emp> list = new ArrayList<Emp>();
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(new FileInputStream("emplist.xml"));
			
			System.out.println("读取完毕");
			
			//document 获取根元素的方法: Element getRootElement()
			Element root = doc.getRootElement();
			
			List<Element> emplist = root.elements();
			for(Element empEle : emplist) {
				//获取子标签
				Element empName = empEle.element("name");
				String name = empName.getTextTrim();
				System.out.println(name);
				
				//获取age
				int age  = Integer.parseInt(empEle.elementText("age"));
				
				//获取性别
				String gender = empEle.elementText("gender");
				
				//获取工资
				int salary = Integer.parseInt(empEle.elementText("salary"));
				
				//获取id
				int id = Integer.parseInt(empEle.attributeValue("id"));

				Emp emp = new Emp(id, name, age, gender, salary);
				list.add(emp);
			}
			
			System.out.println("解析完毕");
			for(Emp emp : list) {
				System.out.println(emp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
