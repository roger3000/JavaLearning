package com.tarena.shoot;

import java.awt.image.BufferedImage;

/**
 * 英雄机
 * 
 * @author Administrator
 * 
 */
public class Hero extends FlyingObject {
	protected BufferedImage[] images; // hero贴图由两张图片组成
	protected int index; // 使两张图片进行交替使用的计数

	private int doubleFire; // 双倍火力子弹数量
	private int life; // 生命数量

	public Hero() {
		this.life = 3;
		this.image = ShootGame.hero1;
		this.images = new BufferedImage[] { ShootGame.hero1, ShootGame.hero2 };
		this.width = this.image.getWidth();
		this.height = this.image.getHeight();
		this.x = 160;
		this.y = 400;
	}

	public void step() {
		if (this.images.length > 0)
			this.image = this.images[this.index++ / 10 % this.images.length];
	}

	public int getDoubleFire() {
		return doubleFire;
	}

	public void setDoubleFire(int doubleFire) {
		this.doubleFire = doubleFire;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
}
