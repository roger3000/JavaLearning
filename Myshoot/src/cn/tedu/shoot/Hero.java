package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject {
	
	private int life;
	private int doubleFire;
	private BufferedImage image ;
	
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

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
		
	
}
