package day04;

import java.util.Random;
import java.util.Scanner;

public class CalculTest {
	public static void main(String[] args) {
		int x,y,z,score=0;
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		for(int i =0;i<10;i++){
			x=rand.nextInt(100);
			y=rand.nextInt(100);
			System.out.println("("+(i+1)+")"+x+"+"+y+"=?");
			z=scan.nextInt();
			if(z==-1){
				break;
			}
			if(x+y == z){
				System.out.println("right!");
				score+=10;
			}else{
				System.out.println("wrong!");
			}
		}
		System.out.println("考试结束,最终成绩"+score);
		scan.close();
	}
}
