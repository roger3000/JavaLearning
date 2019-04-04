package oo.day06;

import java.util.Scanner;


public class BankSys {
	public static void main(String[] args) {
		ICBCImp user1 = new ICBCImp(110, 2000);
		ABCImp user2 = new ABCImp(220, 3000);
		CCBImp user3 = new CCBImp(330, 4000, 10000);
		
		
		Scanner scan = new Scanner(System.in);
		
		UnionPay user = user1;
		
		System.out.println("请输入密码:");
		while(!user.checkPwd(scan.nextInt())){
			System.out.println("密码错误 请重新输入");
		}
		boolean flag = true;
		do{
			System.out.println("密码正确 请输入需要的服务 1 取款 2查询余额 3在线支付 0 退出 ");
			switch(scan.nextInt()){
			case 1:
				System.out.println("请输入取款金额");
				if(user.drawMoney(scan.nextDouble())){
					System.out.println("取款成功 余额"+user.checkBalance());
				}else{
					System.out.println("金额不足");
				}
				break;
			case 2:
				System.out.println("余额:"+user.checkBalance());
				break;
			case 3:
				System.out.println("请输入支付0金额");
				if(user1.onlinePay(scan.nextDouble())){
					System.out.println("支付成功 余额"+user.checkBalance());
				}else{
					System.out.println("支付失败,金额不足");
				}
				break;
			case 0:
				flag = false;
				System.out.println("系统退出");
				break;
			default:
				System.out.println("输入错误");
				break;
			}
		}while(flag);
	}
}


interface UnionPay{
	//检查密码
	boolean checkPwd(int pwd);
	//取款
	boolean drawMoney(double money);
	//查余额
	double checkBalance();
}

interface ICBC extends UnionPay{
	//在线支付
	boolean onlinePay(double money);
}

interface ABC extends UnionPay{
	//支付话费
	boolean payPhone(String phoneNum, double num);
}

interface CCB extends UnionPay{
	//借钱
	boolean lentMoney(double num);
}

class ICBCImp implements ICBC{
	int pwd;
	double money;
	
	public ICBCImp(int pwd, double money) {
		this.pwd = pwd;
		this.money = money;
	}

	@Override
	public boolean checkPwd(int pwd) {
		if(this.pwd == pwd){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean drawMoney(double money) {
		if(this.money >= money){
			this.money -= money;
			return true;
		}else{
			return false;
		}
	}

	@Override
	public double checkBalance() {
		return this.money;
	}

	@Override
	public boolean onlinePay(double money) {
		if(this.money >= money){
			this.money -= money;
			return true;
		}else{
			return false;
		}
	}
	
}

class ABCImp implements ABC{
	double money;
	int pwd;
	
	public ABCImp(int pwd, double money) {
		this.pwd = pwd;
		this.money = money;
	}

	@Override
	public boolean checkPwd(int pwd) {
		if(this.pwd == pwd){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean drawMoney(double money) {
		if(this.money >= money){
			this.money -= money;
			return true;
		}else{
			return false;
		}
	}

	@Override
	public double checkBalance() {
		return this.money;
	}

	@Override
	public boolean payPhone(String phoneNum, double num) {
		if(phoneNum.length() >= 11 && this.money >= num){
			this.money -= num;
			return true;
		}else{
			return false;
		}
	}
	
}

class CCBImp implements CCB{
	int pwd;
	double money;
	double credit;
	
	public CCBImp(int pwd, double money, double credit) {
		this.pwd = pwd;
		this.money = money;
		this.credit = credit;
	}

	@Override
	public boolean checkPwd(int pwd) {
		if(this.pwd == pwd){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean drawMoney(double money) {
		if(this.money >= money){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public double checkBalance() {
		return this.money;
	}

	@Override
	public boolean lentMoney(double num) {
		if(credit >= num){
			credit -= num;
			return true;
		}else{
			return false;
		}
	}
	
}

