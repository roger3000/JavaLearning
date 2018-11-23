package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject {
	
	private int life;
	private int doubleFire;
	private static BufferedImage[] images ;
	static {
		images = new BufferedImage[6];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("hero"+i+".png");
		}
	}
	
	public Hero() {
		super(97, 124, 140, 400);
		this.life = 3;
		this.doubleFire = 0;
	}
	
	void moveTo(int x, int y) {
		this.x = x-(width/2);
		this.y = y-(height/2);
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getDoubleFire() {
		return doubleFire;
	}

	public void setDoubleFire(int doubleFire) {
		this.doubleFire = doubleFire;
	}	
}
