package com.test.shoot1;

import java.awt.image.BufferedImage;

import com.test.shoot.Game;

public class Hero extends FlyingObject {
	private int doubleFire;
	private int life;
	private int index;
	private BufferedImage[] images;
	
	Hero(){
		image = Game.hero1;
		width = image.getWidth();
		height = image.getHeight();
		x = (Game.WIDTH-width)/2;
		y = (Game.HEIGHT-height)/2+100;
		
		doubleFire = 0;
		life = 3;
		index = 0;
		images = new BufferedImage[]{Game.hero1, Game.hero2};
	}
	
	@Override
	public void step(){
		index++;
		image = images[index/10%images.length];
	}
	
	public Bullet[] shoot(){
		Bullet[] bullets;
		if(doubleFire > 0){
			bullets = new Bullet[2];
			bullets[0] = new Bullet(this.x+this.width/7, this.y+20);
			bullets[1] = new Bullet(this.x+this.width/7*6, this.y+20);
			doubleFire-=2;
		}else{
			bullets = new Bullet[1];
			bullets[0] = new Bullet(this.x+this.width/2, this.y+20);
		}
		return bullets;
	}
	
	public boolean outOfBound(){
		return false;
	}
	
	public void moveTO(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void addDoubleFire(){
		doubleFire += 20;
	}
	public void clearDoubleFire(){
		doubleFire = 0;
	}
	
	public void addLife(){
		life++;
	}
	public void subtractLife(){
		life--;
	}
	
	public int getLife(){
		return this.life;
	}
	
	public boolean crashedBy(FlyingObject fo){
		int x1 = fo.x - this.width;
		int x2 = fo.x + fo.width;
		int y1 = fo.y - this.width;
		int y2 = fo.y + fo.height;
		return x > x1
				&&
				x < x2
				&& 
				y > y1
				&&
				y < y2;
	}
}
