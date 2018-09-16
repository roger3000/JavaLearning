package com.test.shoot1;

import java.util.Random;

import com.test.shoot.Game;

public class Bee extends FlyingObject implements Award {
	
	private int award;
	private int xSpeed;
	private int ySpeed;
	Random rand;
	
	Bee(){
		rand = new Random();
		image = Game.bee;
		height = image.getHeight();
		width = image.getWidth();
		x = rand.nextInt(Game.WIDTH - this.width);
		y = -this.height;
		
		award = rand.nextInt(2);
		xSpeed = 1;
		ySpeed = 2;
		if(rand.nextInt(2) == 1){
			xSpeed = -xSpeed;
		}
	}
	
	public int getAward(){
		return award;
	}
	
	@Override
	public void step(){
		this.y += ySpeed;
		this.x += xSpeed;
		if(x >= Game.WIDTH-this.width || x <= 0){
			xSpeed = -xSpeed;
		}
	}
	
	@Override
	public boolean outOfBound() {
		if(this.y >= Game.HEIGHT){
			return true;
		}else{
			return false;
		}
	}
}
