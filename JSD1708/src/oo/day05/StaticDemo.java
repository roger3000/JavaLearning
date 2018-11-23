package oo.day05;

public class StaticDemo {
	public static void main(String[] args) {
		Eoo o1 = new Eoo();
		o1.show();
		Eoo o2 = new Eoo();
		o2.show();
		System.out.println(o1.b);		//建议通过类名访问
		System.out.println(Eoo.b);
	}
}

class Eoo{
	int a;
	static int b;
	Eoo(){
		a++;
		b++;
	}
	
	void show() {
		System.out.println("a = "+a);
		System.out.println("b = "+b);
	}
}
