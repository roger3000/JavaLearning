package oo.day01;

public class StudentTest {
	public static void main(String[] args) {
		Student zs = new Student();
		
		zs.address = "�ӱ��ȷ�";
		zs.age = 25;
		zs.name = "����";
		
		zs.sayHi();
		zs.study();
	}
}

class Student{
	String name;
	int age;
	String address;
	
	public void study() {
		System.out.println(name+"��ѧϰ������");
	}
	
	public void sayHi() {
		System.out.println("��Һã��ҽ�"+name);
	}
}
