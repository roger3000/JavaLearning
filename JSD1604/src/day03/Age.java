package day03;
import java.util.Scanner;

public class Age {
	public static void main(String[] args) {
		int age;
		Scanner scan = new Scanner(System.in);
		System.out.println("age?");
		age = scan.nextInt();

		System.out.println(age<=50 && age>=18);
		scan.close();
	}
}
