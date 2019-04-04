package oo.day04;
//重写与重载的演示
public class OverloadOverrideDemo {
	public static void main(String[] args) {
		//重写看对象, 重载看参数
		Ioo ioo = new Ioo();
		Goo o = new Hoo();
		ioo.test(o);	//重载看参数(Goo)
	}
}
class Ioo{
	void test(Goo o) {
		System.out.println("超类型参数");
		o.show();
	}
	void test(Hoo o) {
		System.out.println("派生类型参数");
		o.show();
	}
}

class Goo{
	void show() {
		System.out.println("超类 show");
	}
}

class Hoo extends Goo{
	void show() {
		System.out.println("派生类 show");
	}
}