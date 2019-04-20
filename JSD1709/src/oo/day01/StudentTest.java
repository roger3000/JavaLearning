package oo.day01;

public class StudentTest {
	public static void main(String[] args) {
		Student zs = new Student();
		
		zs.address = "河北廊坊";
		zs.age = 25;
		zs.name = "张三";
		
		zs.sayHi();
		zs.study();
	}
}

class Student{
	String name;
	int age;
	String address;
	
	public void study() {
		System.out.println(name+"在学习。。。");
	}
	
	public void sayHi() {
		System.out.println("大家好，我叫"+name);
	}
}
