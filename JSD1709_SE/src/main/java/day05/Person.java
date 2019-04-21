package day05;

public class Person {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws Exception {
		this.age = age;
		if(age<0 || age>100) {
			/*
			 * 
			 * throw 用于主动抛出一个异常
			 * 除了runtimeexception及其子类型异常以外
			 * 抛出什么异常就必须在当前的方法上使用throws声明该异常类型
			 * 以通知调用者该捕获什么异常
			 */
			throw new IllegalAgeException("年龄不合法");
		}
	}
	
	
}
