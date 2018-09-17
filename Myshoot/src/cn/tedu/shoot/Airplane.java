package cn.tedu.shoot;

import java.util.Random;

public class Airplane {
	int wigth;
	int height;
	int x;
	int y;
	int speed;
	
	public Airplane() {
		wigth = 49;
		height = 36;
		x = new Random().nextInt(400-wigth);
		y = -height;
		speed = 2;
	}
	
	void step() {
		System.out.println(" "+speed);
	}
}
