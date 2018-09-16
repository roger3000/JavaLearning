package com.test.shoot1;

import com.test.shoot.Game;

public class Bullet extends FlyingObject {
	private int speed;
	
	Bullet(int x, int y){
		image = Game.bullet;
		height = image.getHeight();
		width = image.getWidth();
		this.x = x;
		this.y = y;
		
		speed = 5;
	}
	
	public void step(){
		this.y -= speed;
	}
	
	@Override
	public boolean outOfBound() {
		if(this.y <= -this.height){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean hit(FlyingObject fo){
		int x1 = fo.x-this.width;
		int x2 = fo.x+fo.width;
		int y1 = fo.y-this.height;
		int y2 = fo.y+fo.width;
		return x > x1 
				&&
				x < x2
				&&
				y > y1
				&&
				y < y2;
				
				
	}
}
