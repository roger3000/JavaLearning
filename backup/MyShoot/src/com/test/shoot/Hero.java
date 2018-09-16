package com.test.shoot;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject{
	private int life;
	private int doubleFire;
	private BufferedImage[] images;
	private int index;
	private int changeIntervel;
	private Bullet[] b;
	
	public Hero() {
		this.image = Game.hero1;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.x = (Game.WIDTH-this.width)/2;
		this.y = 400;
		
		this.life = 3;
		this.doubleFire = 10;
		
		images = new BufferedImage[]{Game.hero1, Game.hero2};
		index = 0;
		changeIntervel = 10;
	}
	
	public void step(){
		index++;
		image = images[index/changeIntervel%images.length];
	}
	
	public Bullet[] shoot(){
		if(doubleFire <= 0){
			b = new Bullet[1];
			b[0] = new Bullet(this.x+this.width/2, this.y);
		}else{
			b = new Bullet[2];
			b[0] = new Bullet(this.x+this.width/4, this.y);
			b[1] = new Bullet(this.x+this.width/4*3, this.y);
			doubleFire -= 2;
		}
		
		return b;
	}
	
	public boolean outOfBound(){
		return false;
	}
	
	public void setPos(int x, int y){
		this.x = x;
		this.y = y;
	}
}
