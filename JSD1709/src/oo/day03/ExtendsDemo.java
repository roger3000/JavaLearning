package oo.day03;

public class ExtendsDemo {
	public static void main(String[] args) {
		Stu zs = new Stu();
		zs.sayHi();
		
		Teacher ls = new Teacher();
		ls.sayHi();
		
		Person ww = new Doctor("ww",18,"hn");
		ww.sayHi();
	}
}

class Person{			//超类
	String name;
	int age;
	String address;
	
	void sayHi() {
		System.out.println("hello");
	}
}

class Stu extends Person{}		//派生类

class Teacher extends Person{}	//派生类

class Doctor extends Person{	//派生类
	public Doctor(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	void sayHi() {
		System.out.println(name+" "+age+" "+address);
	}
}
