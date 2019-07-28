package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

public class BigAirplane extends FlyingObject {

	private int speed;
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("bigplane"+i+".png");
		}
	}
	
	public BigAirplane() {
		super(69, 99);
		speed = 1;
	}
	
	public void step() {
		System.out.println("大敌机移动了 "+speed);
	}
}
