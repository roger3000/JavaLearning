package day03;

import java.util.Scanner;

public class CountMonth {
	public static void main(String[] args) {
		int month;
		int year;
		int[] monthList ={31,28,31,30,31,30,31,31,30,31,30,31};
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入年份");
		year = scan.nextInt();
		System.out.println("请输入月份");
		month = scan.nextInt();
		//判断闰年
		if((year%4 == 0 && year%100!=0)
				||
				year%400==0){
			monthList[1] = 29;
		}
		
		System.out.println(year+"年"+month+"月有:"+monthList[month-1]+"天");
	}
}
