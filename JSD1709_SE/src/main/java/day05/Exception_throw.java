
package day05;

public class Exception_throw {
	public static void main(String[] args) {
		Person p = new Person();
		try {
			p.setAge(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(p.getAge());
		System.out.println("程序结束了");
	}
}
