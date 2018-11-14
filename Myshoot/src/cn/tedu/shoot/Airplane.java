package cn.tedu.shoot;

import java.util.Random;
//小敌机
public class Airplane extends FlyingObject {
	
	int speed;
	
	public Airplane() {
		super(49, 36);
		speed = 2;
	}

	public int getWidth() {
		return width;
	}

	public void setWigth(int wigth) {
		this.width = wigth;
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
