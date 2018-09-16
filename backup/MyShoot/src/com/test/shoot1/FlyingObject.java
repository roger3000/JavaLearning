package com.test.shoot1;

import java.awt.image.BufferedImage;

public abstract class FlyingObject {
	protected int x;
	protected int y;
	protected BufferedImage image;
	protected int height;
	protected int width;
	
	public abstract void step();
	public abstract boolean outOfBound();
}
