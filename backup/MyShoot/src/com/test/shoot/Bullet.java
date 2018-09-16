package com.test.shoot;

public class Bullet extends FlyingObject {
	private int speed;
	
	Bullet(int x, int y){
		this.image = Game.bullet;
		this.x = x;
		this.y = y;
		this.height = image.getHeight();
		this.width = image.getWidth();
		
		speed = 5;
	}
	
	public void step(){
		this.y -= speed;
	}
	
	public boolean outOfBound(){
		if(this.y - this.height < 0){
			return true;
		}else{
			return false;
		}
	}
}
