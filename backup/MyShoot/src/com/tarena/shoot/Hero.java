package com.tarena.shoot;

import java.awt.image.BufferedImage;


public class Hero extends FlyingObject {
	private int life;
	private int doubleFire;
	private BufferedImage[] images;
	private int index;		//协助图片切换
	private int intervel;
	private Bullet[] bullets;
	
	public Hero(){
		image = ShootGame.hero0;
		height = image.getHeight();
		width = image.getWidth();		
		x = 150;
		y = 400;		
		life = 3;
		doubleFire = 0;		
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1};
		index =0;
		this.intervel = 10;
	}
	
	public void step(){
		index++;
		image = images[index/intervel%images.length];
	}
	
	public Bullet[] shoot(){
		if(doubleFire <= 0){
			bullets = new Bullet[1];
			bullets[0] = new Bullet(this.x+(width/2)-3, this.y-5);
			return bullets;
		}else{
			bullets = new Bullet[2];
			bullets[0] = new Bullet(this.x+(width/7*1), this.y);
			bullets[1] = new Bullet(this.x+(width/5*4), this.y);
			doubleFire-=2;
			return bullets;
		}
	}
	
	public void movedTo(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean outOfBound(){
		return false;
	}
	
	public void addLife(){
		life++;
	}
	
	public int getLife(){
		return this.life;
	}
	
	public void subtractLife(){
		life--;
	}
	
	public void clearDoubleFire(){
		doubleFire = 0;
	}
	
	public void addDoubleFire(){
		doubleFire+=40;
	}
	
	public boolean hit(FlyingObject obj){
		int x1 = obj.x - this.width/2;
		int x2 = obj.x + this.width/2;
		int y1 = obj.y - this.height/2;
		int y2 = obj.y + this.height/2;
		
		int x = this.x + this.width/2;
		int y = this.y + this.height/2;
		
		return x1 < x && x < x2
				&&
				y1 < y && y < y2;
	}
}
