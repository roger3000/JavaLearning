package com.test.shoot1;

import java.util.Random;

import com.test.shoot1.Game;


public class EnemyPlane extends FlyingObject implements Enemy {
	private int speed;
	Random rand;
	
	EnemyPlane(){
		rand = new Random();
		this.image = Game.enemyplane;
		this.height = image.getHeight();
		this.width = image.getWidth();
		this.x = rand.nextInt(Game.WIDTH - this.width);
		this.y = -this.height;
		
		speed = 2;
	}
	
	//击毁敌机获得分数
	public int getScore(){
		return 5;
	}
	
	public void step(){
		this.y += speed;
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
