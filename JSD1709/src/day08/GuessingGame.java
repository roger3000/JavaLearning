package day08;

import java.util.Scanner;

//猜字符游戏
public class GuessingGame {
	//主方法
	public static void main(String[] args) {
		//生成随机数组
		char[] chs = generate();
		System.out.println("游戏开始");
		System.out.println(chs); //char[] 可直接输出
		int score = 500;
		
		while (true) {
			System.out.println("请输入字母： ");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			String s = scan.nextLine().toUpperCase();
			if (s.equals("EXIT")) {  		//基本类型才能用== ，String非基本类型 需要用equals
				System.out.println("游戏结束 草泥马");
				break;
			}
			int[] result = check(chs, s.toCharArray());
			if(result[0] == chs.length && result[1] == chs.length) {
				System.out.println("猜对了！ 游戏结束,最终得分："+score);
				break;
			}else {
				System.out.println("猜对了"+result[0]+"个，猜对了"+result[1]+"个位置");
				score-=10;
			}
		}
	}
	//生成字符数组, 不能有字符重复
	public static char[] generate() {
		char[] chs = new char[5];
//		for (int i = 0; i < chs.length; i++) {
//			chs[i] = (char) ('A'+Math.random()*('Z'-'A'+1));
//		}
		char[] verb = {'A','B','C','D','E','F','G','H','I','J','K',
		                       'L','M','N','O','P','Q','R','S','T',
		                       'U','V','W','X','Y','Z'};
		boolean[] flags = new boolean[verb.length];
		for (int i = 0; i < chs.length; i++) {
			int pos;
			do {
				pos = (int)(Math.random()*verb.length);
			}while(flags[pos]);
			
			chs[i] = verb[pos];
			flags[pos] = true;
		}
		return chs;
	}
	//字符数组对比
	public static int[] check(char[] chs, char[] input) {
		//result[0]: 正确的字符数； result[1]： 正确的位置
		int[] result = new int[2];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < chs.length; j++) {
				if(input[i] == chs[j]) {
					result[0]++;
					if(i == j) {
						result[1]++;
					}
					break;	//剩下的chs不参与对比
				}
			}
		}
		
		return result;
	}
}
