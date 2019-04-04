package day03;

import java.util.Scanner;

public class LeapYear {
	public static void main(String[] args) {
		int year;
		Scanner scan = new Scanner(System.in);
		System.out.println("year?");
		year = scan.nextInt();
		if((year%4==0 && year%100!=0)
				||
				year%400==0){
			System.out.println("闰年");
		}else {
			System.out.println("不是闰年");
		}
		
		scan.close();
	}
}
