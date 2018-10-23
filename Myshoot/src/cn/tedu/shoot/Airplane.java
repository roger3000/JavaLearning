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

	public int getWigth() {
		return wigth;
	}

	public void setWigth(int wigth) {
		this.wigth = wigth;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
}
