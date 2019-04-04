package oo.day07;

import java.util.Scanner;

public class BankSys {
	public static void main(String[] args) {
		ABCImp card1 = new ABCImp(111, 20000);
		ICBCImp card2 = new ICBCImp(111, 10000);
		
		ABCATM atm = new ABCATM();
		
		atm.inserCard(card2);
		atm.checkPwd();
		atm.menu();
	}
}

interface ICBC{
	boolean payOnline(double money);
}

interface ABC{
	boolean payPhone(String phoneNum, double money);
}

class UnionPay{
	
	private int pwd;
	private double money;
	
	public UnionPay(int pwd, double money) {
		this.pwd = pwd;
		this.money = money;
	}
	
	public double checkBalance(){
		return money;
	}
	
	public boolean checkPwd(int pwd){
		if(this.pwd == pwd){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean drawMoney(double money){
		if(this.money >= money){
			this.money -= money;
			return true;
		}else{
			return false;
		}
	}
	
	public int getPwd() {
		return pwd;
	}

	public void setPwd(int pwd) {
		this.pwd = pwd;	
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
}

class ICBCImp extends UnionPay implements ICBC{
	public ICBCImp(int pwd, double money) {
		super(pwd, money);
	}
	public boolean payOnline(double money){
		if(this.getMoney() >= money){
			return true;
		}else{
			return false;
		}
	}
}

class ABCImp extends UnionPay implements ABC{	
	public ABCImp(int pwd, double money) {
		super(pwd, money);
	}

	@Override
	public boolean payPhone(String phoneNum, double money) {
		if(phoneNum.length() >= 11 && this.getMoney() >= money){
			double tempMoney = this.getMoney();
			this.setMoney(tempMoney -= money);
			return true;
		}else{
			return false;			
		}
	}
	
	
}

class ABCATM{
	
	UnionPay card;
	Scanner scan = new Scanner(System.in);
	
	public void inserCard(UnionPay card){
		this.card = card;
	}
	
	public void checkPwd(){
		System.out.println("请输入密码:");
		while(card.getPwd() != scan.nextInt()){
			System.out.println("密码错误 请重新输入:");
		}
		
		System.out.println("密码正确");
	}
	
	public void menu(){
		
		boolean flag = true;
		while(flag){
			if(card instanceof ABC){
				System.out.println("请输入要进行的操作1. 查余额 2. 取款 3.支付话费 0.退出 ");
			}else{
				System.out.println("请输入要进行的操作1. 查余额 2. 取款  0.退出");
			}
			switch(scan.nextInt()){
			case 1:
				System.out.println("您的卡里余额"+card.checkBalance());;
				break;
			case 2:
				System.out.println("请输入取款金额");
				if(card.drawMoney(scan.nextDouble())){
					System.out.println("取款成功,余额:"+card.getMoney());
				}
				break;
			case 3:
				if(card instanceof ABC){
					System.out.println("请输入电话号码");
					String phoneNum = scan.next();
					System.out.println("请输入金额");
					double money = scan.nextDouble();
					ABC ABCCard = (ABC)card;
					if(ABCCard.payPhone(phoneNum, money)){
						System.out.println("充值成功 余额:"+card.checkBalance());
					}else{
						System.out.println("充值失败 余额不足");
					}
				}else{
					System.out.println("输入错误 请重新输入");
				}
				break;
			case 0:
				flag = false;
				break;
			default:
				System.out.println("输入错误 请重新输入");
				break;
			}
		}
		
		System.out.println("thank you for using");
	}
}