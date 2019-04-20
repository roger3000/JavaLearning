package oo.day05.vis;

interface IFace{}
class CFace implements IFace{}
class Other{}


public class Test{
	public static void main(String[] args) {
		Object o = new Object() {
			public int hashCode() {
				return 42;
			}
		};
		System.out.println(o.hashCode());
	}
	
}
