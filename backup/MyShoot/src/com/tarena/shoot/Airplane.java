package com.tarena.shoot;

import java.util.Random;

import com.test.shoot.Game;

public class Airplane extends FlyingObject implements Enemy {
	private int speed = 2;
	
	public Airplane(){
		image = ShootGame.airplane;
		
		height = image.getHeight();
		width = image.getWidth();
		
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - this.width);
		y = ( - this.height);
	}
	
	public int getScore(){
		return 5;
	}
	
	public void step(){
		y += speed;
	}
	
	public boolean outOfBound(){
		if(this.y > Game.HEIGHT){
			return true;
		}else{
			return false;
		}
	}
}
