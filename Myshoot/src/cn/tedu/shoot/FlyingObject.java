package cn.tedu.shoot;

import java.util.Random;

/** 飞行物*/
public class FlyingObject {
	int height;
	int width;
	int x;
	int y;
	
	public FlyingObject() {
	}
	
	public FlyingObject(int width, int height) {
		this.width = width;
		this.height = height;
		x = new Random().nextInt(400-width);
		y = -height;
	}
	
	public FlyingObject(int width, int height, int x, int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	
	//飞行物移动
	void step() {
		System.out.println("飞行物移动了");
	}
}
