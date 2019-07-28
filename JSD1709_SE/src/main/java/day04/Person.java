package day04;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 使用当前类的实例测试对象流的对象读写操作
 * 
 * 当前类的实例若希望被对象流读写, 那么就必须事项
 * java.io.serializable接口
 * 并且.当前类中诉讼有引用类型的属性他们的类也必须实现该接口
 * 当一个类实现了serializable接口,那么再编译的时候,编译器会隐含的
 * 在class文件中添加一个方法,用于当前对象转化成一组字节
 * @author lifer
 *
 */
public class Person implements Serializable{
	/**
	 * 当一个类实现了serializable接口后
	 * 应当定义一个常量:serialVersionUID
	 * 他是序列化版本号,编译器会在当前类编译时更具当前类结构生成一个版本号
	 * 
	 * 版本号决定反序列化当前实例时时候可以成功
	 * 当版本号一致时反序列化成功,不一致时
	 * 对象输入流在进行反序列化时会抛出异常
	 * 
	 * 若当前类结构发现改变,但是版本号没有改变的前提下
	 * 原来的对象时可以反序列化的
	 * 这时会采取兼容模式,即:还原所有属性
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private String gender;
	//通过transient修饰的属性在序列化时会被忽略
	private transient String[] otherInfo;
	
	public Person() {
		
	}
	public Person(String name, int age, String gender, String[] otherInfo) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.otherInfo = otherInfo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String[] otherInfo) {
		this.otherInfo = otherInfo;
	}
	
	public String toString() {
		return name+","+age+","+gender+","+Arrays.toString(otherInfo);
	}
}
