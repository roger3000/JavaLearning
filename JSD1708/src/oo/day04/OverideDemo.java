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
