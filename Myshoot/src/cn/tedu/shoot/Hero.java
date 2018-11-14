package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject {
	
	int life;
	int doubleFire;
	BufferedImage image ;
	
	public Hero() {
		super(97, 124, 140, 400);
		this.life = 3;
		this.doubleFire = 0;
	}
	
	void moveTo(int x, int y) {
		this.x = x-(width/2);
		this.y = y-(height/2);
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
	
	
}
