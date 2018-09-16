package com.tarena.shoot;

import java.awt.image.BufferedImage;

public abstract class FlyingObject {
	
	protected BufferedImage image;
	
	protected int width;
	protected int height;
	
	protected int x;
	protected int y;
	
	public abstract void step();
	
	public abstract boolean outOfBound();
	
	public boolean shootBy(Bullet b){
		int x1 = this.x;
		int x2 = this.x+this.width;
		int y1 = this.y;
		int y2 = this.y+this.height;
		
		return x1 < b.x && b.x < x2
				&&
				y1 < b.y && b.y < y2;
	}

}
