package day03;

import java.util.Scanner;

public class IncomeTax {
	public static void main(String[] args) {
		
		float tax;
		float finalTax;
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入税前收入");
		tax = scan.nextFloat();
		float tempTax = tax-3500;
		if(tax>=80000){
			finalTax = (float) (tempTax*0.45-13505);
		}else if(tax>=55000){
			finalTax = (float)(tempTax*0.35-5505);
		}else if(tax>=35000){
			finalTax = (float)(tempTax*0.30-2755);
		}else if(tax>=9000){
			finalTax = (float)(tempTax*0.25-1005);
		}else if(tax>=4500){
			finalTax = (float)(tempTax*0.20-555);
		}else if(tax>=1500){
			finalTax = (float)(tempTax*0.10-105);
		}else{
			finalTax = (float)(tempTax*0.03);
		}
		
		System.out.println(finalTax);
	}
}
