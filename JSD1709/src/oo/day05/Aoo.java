package oo.day05;

public class Aoo {
	public int a;	//任何类
	protected int b;//本类 子类 同胞类
	int c;			//本类 同胞类
	private int d;	//本类
	
	void show() {
		a = 1;
		b = 2;
		c = 3;
		d = 4;
	}
}


class Boo{
	void show() {
		Aoo o = new Aoo();
		o.a = 1;
		o.b = 2;
		o.c = 3;
//		o.4 = 4;		//报错 访问权限为private
	}
}