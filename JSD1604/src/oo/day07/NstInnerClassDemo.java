package oo.day07;

public class NstInnerClassDemo {
	public static void main(String[] args) {
		Inter2 o1 = new Inter2(){};
		
		final int num = 5;
		Inter3 o3 = new Inter3(){
			public void show(){
				System.out.println("hello world");
				System.out.println(num); 		//匿名内部内中访问外部数据 该数据必须是final
			}
		};
		
		o3.show();
	}
}

interface Inter2{}

interface Inter3{
	void show();
}