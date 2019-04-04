package oo.day05;

import java.util.Scanner;

public class UnionPayTest {
	public static void main(String[] args) {
		ICBC o1 = new ICBC("110", 110, 2000);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("请输入密码");
		while(!o1.checkPwd(scan.nextInt())){
			System.out.println("密码错误, 请重新输入");
		}
		System.out.println("密码输入正确");
		System.out.println("请输入取款金额");
		if(o1.drawMoney(scan.nextDouble())){
			System.out.println("取款成功, 余额为"+o1.getbalance());
		}else{
			System.out.println("取款失败 余额不足");
		}
		
		scan.close();
	}
}

interface UnionPay{
	//检查密码
	public boolean checkPwd(int input);
	
	//取钱
	public boolean drawMoney(double input);
	
	//查看余额
	public double getbalance();
	
}

interface ICBCIT extends UnionPay{
	public void payOnline(double pay);
}

interface ABCIT extends UnionPay{
	public boolean payPhone(String phoneNum, double pay);
}

class ICBC implements ICBCIT{
	
	private String code;
	private double money;
	private int pwd;
	
	public ICBC(String code, int pwd, double money) {
		this.code = code;
		this.money = money;
		this.pwd = pwd;
	}

	@Override
	public boolean checkPwd(int input) {
		if(pwd == input){
			return true;
		}else{
			return false;			
		}
	}

	@Override
	public boolean drawMoney(double input) {
		if(money >= input){
			money -=input;
			return true;
		}else{
			return false;			
		}
	}

	@Override
	public double getbalance() {
		return money;
	}

	@Override
	public void payOnline(double pay) {
		if(money > pay){
			money -= pay;
		}
		
	}
}

class ABC implements ABCIT{
	private String code;
	private int pwd;
	private double money;
	
	public ABC(String code, int pwd, double money) {
		this.code = code;
		this.pwd = pwd;
		this.money = money;
	}

	@Override
	public boolean checkPwd(int input) {
		if(pwd == input){
			return true;
		}else{
			return false;			
		}
	}

	@Override
	public boolean drawMoney(double input) {
		if(money > input){
			return true;
		}else{			
			return false;
		}
	}

	@Override
	public double getbalance() {
		return money;
	}

	@Override
	public boolean payPhone(String phoneNum, double pay) {
		if(phoneNum.length() ==11 && money >= pay){
			return true;
		}else{
			return false;
		}
	}
	
}