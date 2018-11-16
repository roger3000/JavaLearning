package cn.tedu.shoot;

import java.util.Random;

public class Bee extends FlyingObject{

	int xSpeed;
	int ySpeed;
	int awardType;
	
	public Bee() {
		super(60, 50);
		xSpeed = 1;
		ySpeed = 2;
		awardType = new Random().nextInt(2);
	}
	
	public void step() {
		System.out.println("小蜜蜂X轴移动了: "+xSpeed);
		System.out.println("小蜜蜂y轴移动了:"+ySpeed);
	}
}
