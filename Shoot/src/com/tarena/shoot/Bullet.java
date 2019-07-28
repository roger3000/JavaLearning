package com.tarena.shoot;

/**
 * ×Óµ¯
 * 
 * @author Administrator
 * 
 */
public class Bullet extends FlyingObject {
	private int speed;

	public Bullet(int x, int y) {
		this.speed = 3;
		this.x = x;
		this.y = y;
		this.image = ShootGame.bullet;
	}

	public void step() {
		this.y -= this.speed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
