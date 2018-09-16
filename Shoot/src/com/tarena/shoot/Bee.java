package com.tarena.shoot;

import java.util.Random;

/**
 * 蜜蜂
 * 
 * @author Administrator
 * 
 */
public class Bee extends FlyingObject implements Award {
	private int xSpeed; // x坐标移动速度
	private int ySpeed; // y坐标移动速度
	private int awardType; // 奖励类型

	public Bee() {
		this.xSpeed = 1;
		this.ySpeed = 2;
		this.image = ShootGame.bee;
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
		Random rand = new Random();
		this.x = rand.nextInt(ShootGame.WIDTH - this.width);
		this.y = -this.height;
		// x = 100;y = 200;
		this.awardType = rand.nextInt(2);
	}

	public void step() {
		this.y += this.ySpeed;
		if (this.x > ShootGame.WIDTH - this.width)
			this.xSpeed = -1;
		if (this.x < 0)
			this.xSpeed = 1;
		this.x += this.xSpeed;
	}

	public int getAwardType() {
		return awardType;
	}

	public int getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public int getySpeed() {
		return ySpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
}
