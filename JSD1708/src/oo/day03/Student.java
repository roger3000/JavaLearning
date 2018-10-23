package oo.day03;

public class Student {
	String name;
	int age;
	String address;
	Student(){
		this(null,0,null);
	}
	Student(String name, int age){
		this(name, age, null);
	}
	
	Student(String name, int age, String address){
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public void say() {
		System.out.println("我叫"+name+"我有"+age+"岁，我现在在"+address);
	}
}
