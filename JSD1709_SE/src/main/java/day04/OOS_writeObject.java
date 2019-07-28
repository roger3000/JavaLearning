package day04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 对象流
 * java.io.ObjectInputStream
 * 对象输入流，可以读取一组字节并抓换位对应的对象
 * 前提是该组字节必须是对象输出流写出的一个对象所转换的字节
 * java.io.ObjectOutputStream
 * 对象输入流，可以将给定的对象转换为一组字节后写出
 * @author lifer
 *
 */
public class OOS_writeObject {
	public static void main(String[] args) throws IOException {
		Person p1 = new Person("张三",16,"男",new String[] {
				"是一名演员","爱好书法","和蔼可亲"
				})  ;
		System.out.println(p1);
		FileOutputStream fos = 
				new FileOutputStream("person.obj");
//		FileInputStream fis = 
//				new FileInputStream("person.obj");
//		ObjectInputStream ois = 
//				new ObjectInputStream(fis);
		ObjectOutputStream oos = 
				new ObjectOutputStream(fos);
		/*
		 * 对象输出流提供写出对象方法
		 * writeObject(Object obj)
		 * 该方法会将给定对象按照其结构转换为一组字节后再通过其处理的流将其写出
		 * 需要注意,给定的对象所属类必须实现可序列化接口,否则会抛出异常
		 * 
		 * 这里将对象写入文件经历了两个步骤
		 * 1.ObjectOutputStream 将p1首先转换成了一组字节
		 * 这个过程称之为序列化
		 * 2.FileOutputStream 将序列化后的字节写入到文件中
		 * 这个过程称之为:数据持久化
		 */
		oos.writeObject(p1);
		System.out.println("输出完毕");
		oos.close();
//		ois.close();
	}
}
