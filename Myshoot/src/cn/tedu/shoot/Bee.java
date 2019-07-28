package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Bee extends FlyingObject{

	private int xSpeed;
	private int ySpeed;
	private int awardType;
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("bee"+i+".png");
		}
	}
	
	
	public Bee() {
		super(60, 50);
		xSpeed = 1;
		ySpeed = 2;
		awardType = new Random().nextInt(2);
	}
	
	public void step() {
		System.out.println("小蜜蜂X轴移动了: "+xSpeed);
		System.out.println("小蜜蜂y轴移动了:"+ySpeed);
	}
}
