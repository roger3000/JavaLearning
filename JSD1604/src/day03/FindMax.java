package day03;

import java.util.Scanner;

public class FindMax {
	public static void main(String[] args) {
		int x,y;
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入两个数");
		x = scan.nextInt();
		y = scan.nextInt();
		
		if(x>y){
			System.out.println(x);
		}else{
			System.out.println(y);
		}		
	}
}
