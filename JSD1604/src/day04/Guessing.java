package day04;

import java.util.Random;
import java.util.Scanner;


public class Guessing {
	public static void main(String[] args) {
		//int destination = (int)(Math.random()*100);
		
		Random rand = new Random();
		int destination = rand.nextInt(100);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("请输入数字");
		
		int guess = scan.nextInt();
		
		while(guess!=destination){
			if(guess>destination){
				System.out.println("猜大了");
			}else {
				System.out.println("猜小了");
			}
			System.out.println("请再次输入数字");
			guess = scan.nextInt();
		}
		
		if(guess==destination){
			System.out.println("恭喜你,猜对了!");
		}
		
		scan.close();
	}
}
