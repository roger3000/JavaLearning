package oo.day04;
//重写的演示
public class OverideDemo {
	public static void main(String[] args) {
		Coo o1 = new Coo();
		o1.show();
		
		Doo o2 = new Doo();
		o2.show();
		
		Coo o3 = new Doo();
		o3.show();
	}
}

class Coo{
	int c;
	void show() {
		System.out.println("父类");
	}
}

class Doo extends Coo{
	int d;
	@Override
	void show() {
		System.out.println("子类");
//		super.show();
	}
	
}
/**
 * 重写遵守两同两小一大原则
 * 1) 两同:
 * 		方法名相同
 * 		参数列表相同
 * 2) 两小
 * 		返回值小与或等于超类
 * 			void时 必须相等
 * 			基本类型时 必须相等
 * 			引用类型时 小于或等于
 * 		抛出的异常小
 * 3) 一大
 * 		访问权限大
 */

class Eoo{
	void show() {}
	
//	double say() {}
	
	Foo sayHi() {return null;}
}

class Foo extends Eoo{
//	int show() {}	//编译错误 void时只能相等
//	int say() {}	//编译错误 基本类型 必须一样
//	Eoo sayHi() {return null;}	//编译错误 Eoo大于Foo
}
