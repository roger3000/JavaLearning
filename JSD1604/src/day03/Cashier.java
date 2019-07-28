package day03;

import java.util.Scanner;

public class Cashier {
	public static void main(String[] args) {
		double unitPrice,money;
		int amount;
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入单价");
		unitPrice = scan.nextInt();
		System.out.println("请输入数量");
		amount = scan.nextInt();
		System.out.println("请输入金额");
		money = scan.nextInt();
		
		//应收金额
		double totalPrice = unitPrice * amount;
		if (totalPrice>=500 && totalPrice<999) {
			totalPrice *= 0.8;
		}else if(totalPrice>=1000){
			totalPrice *= 0.7;
		}else{
			totalPrice *= 0.9;
		}
		
		//计算找零
		double change = money - totalPrice;
		if (change<0) {
			System.out.println("金额不足");
		} else {
			System.out.println("应收:"+totalPrice+"已收:"+money+"找零:"+change);
		}
		scan.close();
	}	
}
