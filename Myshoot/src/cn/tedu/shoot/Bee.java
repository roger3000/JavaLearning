package cn.tedu.shoot;

import java.util.Random;

public class Bee {
	int width;
	int height;
	int x;
	int y;
	int xSpeed;
	int ySpeed;
	int awardType;
	
	public Bee() {
		width =  60;
		height = 50;
		x = new Random().nextInt(400-width);
		y = -height;
		xSpeed = 1;
		ySpeed = 2;
		awardType = new Random().nextInt(2);
	}
	
	void step() {
		System.out.println(" "+xSpeed);
		System.out.println(" "+ySpeed);
	}
}
