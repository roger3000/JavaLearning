package com.tarena.shoot;

import java.awt.image.BufferedImage;

/**
 * Ӣ�ۻ�
 * 
 * @author Administrator
 * 
 */
public class Hero extends FlyingObject {
	protected BufferedImage[] images; // hero��ͼ������ͼƬ���
	protected int index; // ʹ����ͼƬ���н���ʹ�õļ���

	private int doubleFire; // ˫�������ӵ�����
	private int life; // ��������

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
