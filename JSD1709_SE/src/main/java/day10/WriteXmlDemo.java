package day10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 生成xml
 * @author 许皓泉
 *
 */
public class WriteXmlDemo {
	public static void main(String[] args) {
		/*
		 * 生成XML的步骤
		 * 1. 创建一个document对象表示一个空白文档
		 * 2 向document对象中添加根元素
		 * 3 按照预定的XML文档结构从更元素开始逐级添加子元素
		 * 4 创建XMKWriter
		 * 5 通过XMLWriter将Document写出以形成XML文档
		 */
		
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp(7, "tom", 18, "男", 19999));
		list.add(new Emp(8, "jerry", 19, "男", 2009));
		list.add(new Emp(9, "dandy", 20, "男", 199));
		
		Document doc = DocumentHelper.createDocument();
		//该方法只能用一次
		Element root = doc.addElement("list");
		
		/*
		 * 将每一个emp实例以一个<emp>标签的形式添加到根标签中
		 */
		for(Emp emp: list) {
			Element sonEle = root.addElement("emp");
			
			Element nameEle = sonEle.addElement("name");
			nameEle.addText(emp.getName());
			
			Element ageEle = sonEle.addElement("age").addText(emp.getName()+"");
			
			Element genderEle = sonEle.addElement("gender").addText(emp.getGender());
			
			Element salaryEle = sonEle.addElement("salary").addText(emp.getSalary()+"");
			
			sonEle.addAttribute("id", emp.getId()+"");
		}
		
		try {
			XMLWriter writer = new XMLWriter(
					new FileOutputStream("myemp.xml"),
					OutputFormat.createPrettyPrint()
					);
			writer.write(doc);
			System.out.println("写出完毕");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
