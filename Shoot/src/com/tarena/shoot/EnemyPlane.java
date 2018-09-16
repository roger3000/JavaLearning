package com.tarena.shoot;

import java.util.Random;

/**
 * �л�---���Ƿ�����Ҳ�Ƿ���
 * 
 * @author Administrator
 * 
 */
public class EnemyPlane extends FlyingObject implements Score {
	private int speed; // �ƶ��ٶ�

	public EnemyPlane() {
		this.speed = 2;
		this.image = ShootGame.enemyplane;
		this.width = image.getWidth();
		this.height = image.getHeight();
		Random rand = new Random();
		this.x = rand.nextInt(ShootGame.WIDTH - this.width);
		this.y = -this.height;
		// x = 100;y =100;
	}

	public void step() {
		this.y += this.speed;
	}

	public int getScore() {
		return 5;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
