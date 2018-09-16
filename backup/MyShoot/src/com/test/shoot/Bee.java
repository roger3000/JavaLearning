package com.test.shoot;

import java.util.Random;

public class Bee extends FlyingObject implements Award {

	private int xSpeed;
	private int ySpeed;
	private int award;
	Random rand = new Random();
	
	public Bee() {
		this.image = Game.bee;
		this.height = image.getHeight();
		this.width = image.getWidth();
		this.x = rand.nextInt(Game.WIDTH - this.width);
		this.y = -this.height;

		xSpeed = 1;
		ySpeed = 2;

		if(rand.nextInt(10) < 5){
			xSpeed = -xSpeed;
		}
				
		award = rand.nextInt(2);
	}
	
	public int getAward(){
		return award;
	}
	
	public void step(){
		this.y += ySpeed;	
		this.x += xSpeed;
		
		if(this.x >= Game.WIDTH-this.width || this.x <= 0){
			xSpeed = -xSpeed;
		}
	}
	
	public boolean outOfBound(){
		if(this.y > Game.HEIGHT){
			return true;
		}else{
			return false;
		}
	}
}
