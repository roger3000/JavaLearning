package oo.day07;

public class InnerClassDemo {
	public static void main(String[] args) {
		Mama mama = new Mama();
		Mama.Baby baby = mama.baby(); //访问内部类
//		Baby baby = new Baby();
	}
}

class Mama{
	private String name;
	Baby baby(){
		return new Baby(); 
	}
	
	class Baby{
		public void showMamaName(){
			System.out.println(name);
			System.out.println(Mama.this.name);
//			System.out.println(this.name);
		}
	}
}