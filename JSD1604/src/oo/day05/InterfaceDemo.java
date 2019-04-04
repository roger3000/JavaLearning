package oo.day05;

public class InterfaceDemo {
	public static void main(String[] args){
//		Inter4 o1 = new Inter4();
		
		Inter4 o2 = new Eoo();
		
		Inter3 o3 = new Eoo();
	}
}

interface Inter1{
	int NUM = 0;
	void show();	
}

interface Inter2{
	void a();
	void b();
}

interface Inter3{
	void c();
}

class Aoo implements Inter2{
	public void a(){}
	
	public void b(){}
}

class Boo implements Inter3,Inter2{

	@Override
	public void a() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void b() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void c() {
		// TODO Auto-generated method stub
		
	}
	
}

abstract class Coo{
	abstract void d();
}

class Doo extends Coo implements Inter2,Inter3{
	public void a(){}
	
	public void b(){}
	
	public void c(){}
	
	public void d(){}
	
}

interface Inter4 extends Inter3{
	
	void e();
	
}

class Eoo implements Inter4{
	public void c(){}
	
	public void e(){}
}