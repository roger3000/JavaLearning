package oo.dayo2;

/**
 * 
 * @author roger
 *
 *
 *补充: 一个文件内可以有多个类
 *public修饰的类, 只能有一个
 *public修饰的类, 必须与文件名相同
 */
public class OverloadDemo {
	public OverloadDemo() {
		// TODO Auto-generated constructor stub
	}
	public OverloadDemo(String name, int age) {
		
	}
	public static void main(String[] args) {
		Aoo o = new Aoo();
		o.say();
		o.say(25);
		o.say("张三", 25);
		o.say(25, "张三");
	}
}

class Aoo{
	void say() {}
	void say(String name) {}
	void say(int age) {}
	void say(String name, int age) {}
	void say(int age, String name) {}
	
//	int say() {} //编译错误 重载与返回类型无关
}


