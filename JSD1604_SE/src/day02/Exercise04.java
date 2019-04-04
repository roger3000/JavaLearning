package day02;
/**
 * email:fancq@tedu.cn
 * @author Administrator
 *
 */
public class Exercise04 {
	public static void main(String[] args) {
		Person p1 = new Person("张三", 25, 5000);
		Person p2 = new Person("张三", 23, 3000);
		System.out.println(p1);
		System.out.println(p1.equals(p2));
	}
}
class Person{
	private String name;
	private int age;
	private int salary;
	public Person(){
		
	}
	public Person(String name, int age, int salary){
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String toString(){
		return this.name+','+this.age+','+this.salary;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Person){
			Person p = (Person)obj;
			return this.name==p.name;
		}
		return false;
	}
}
