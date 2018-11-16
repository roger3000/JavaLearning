package cn.tedu.shoot;

import java.util.Random;

public class BigAirplane extends FlyingObject {

	int speed;
	
	public BigAirplane() {
		super(69, 99);
		speed = 1;
	}
	
	public void step() {
		System.out.println("大敌机移动了 "+speed);
	}
}
