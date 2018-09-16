package com.tarena.shoot;


public class Bullet extends FlyingObject {
	private int speed = 5;
	
	public Bullet(int x, int y){
		image = ShootGame.bullet;
		
		height = image.getHeight();
		width = image.getWidth();
		
		this.x = x;
		this.y = y;
	}
	
	public void step(){
		y -= speed;
	}
	
	public boolean outOfBound(){
		if(this.y < -this.height){
			return true;
		}else{
			return false;
		}
	}
}
