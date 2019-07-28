import java.util.Vector;

public class Test02 extends Vector {
	int a, b, c, d;
	int i = 1;
	public Test02(){}
	public Test02(int a, int b){
		this.a = a;
		this.b = b;
		i =2;
	}
	public Test02(int a, int b, int c, int d){
		this(a, b);
		this.a=a;this.b=b;
		
	}
	private static int x = 1;
	public static void main(String[] args) {
		Test02 t2 = new Test02();
		t2.x++;
		
		Object obj = new Object(){
			public int hashCode(){
				return 42;
			}
		};
		
		System.out.println(obj.hashCode());
	}
}
