package cn.tedu.shoot;

import java.util.Random;

public class BigAirplane extends FlyingObject {

	int speed;
	
	public BigAirplane() {
		width = 69;
		height = 99;
		x = new Random().nextInt(400-width);
		y = -height;
		speed = 1;
	}
	
	void step() {
		System.out.println(" "+speed);
	}
}
