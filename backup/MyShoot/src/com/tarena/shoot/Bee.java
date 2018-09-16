package com.tarena.shoot;

import java.util.Random;

import com.test.shoot.Game;

public class Bee extends FlyingObject implements Award {
	private int xSpeed = 1;
	private int ySpeed = 2;
	private int awardType;
	private Random rand;
	
	public Bee(){
		image = ShootGame.bee;
		
		height = image.getHeight();
		width = image.getWidth();
		
		rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - this.width);
		y = ( - this.height);
		
		if(rand.nextInt(10) <= 5){
			xSpeed = -xSpeed;
		}
		
		awardType = rand.nextInt(2);
	}
	
	public int getType(){
		return awardType;
	}
	
	public void step(){
		rand = new Random();
		y += ySpeed;
		x += xSpeed;
		if(x >= (Game.WIDTH-this.width) || x <= 0){
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
