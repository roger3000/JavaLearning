package com.test.shoot;

import java.util.Random;

public class EnemyPlane extends FlyingObject implements Enemy{
	private int speed;
	Random rand = new Random();
	
	public EnemyPlane() {
		this.image = Game.enemyplane;
		this.height = image.getHeight();
		this.width = image.getWidth();
		this.x = rand.nextInt(Game.WIDTH - this.width);
		this.y = -this.height;
		
		speed = 2;
	}
	
	public int getScore(){
		return 5;
	}
	
	public void step(){
		this.y += speed;
	}
	
	public boolean outOfBound(){
		if(this.y > Game.HEIGHT){
			return true;
		}else{
			return false;
		}
	}
}
