package day03;

import java.util.Scanner;

public class ScoreLevel {
	public static void main(String[] args) {
		int score;
		String level;
		System.out.println("score?");
		Scanner scan = new Scanner(System.in);
		score = scan.nextInt();
		if(score > 100 || score < 0){
			level = "不合法";
		}else if (score>=90) {
			level="A";
		}else if(score >=80){
			level = "B";
		}else if (score >=60) {
			level = "C";
		}else{
			level = "D";
		}
		System.out.println(level);
		
		scan.close();
	}
}
