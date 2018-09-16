package com.test.shoot;

import java.awt.image.BufferedImage;

public abstract class FlyingObject {
	
	protected BufferedImage image;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	public abstract void step();
	public abstract boolean outOfBound();
	
}
