package cn.tedu.shoot;

import java.util.Random;
//小敌机
public class Airplane extends FlyingObject {
	
	private int speed;
	
	public Airplane() {
		super(49, 36);
		speed = 2;
	}
	
	//小敌机移动
	public void step() {
		System.out.println("小敌机移动了"+ speed);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
}