package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**
 * 背景
 * @author roger
 *
 */
public class Sky extends FlyingObject {
	private static BufferedImage image;
	static {
		image = loadImage("background.png");
	}
	
	private int speed;
	private int y1;		//y1坐标(图片轮换)
	
	public Sky() {
		super(World.WIDTH, World.HEIGHT, 0, 0);
		speed = 1;
		y1 = -height;
	}
	
	/**
	 * 天空移动
	 */
	public void step() {
		System.out.println("天空的y坐标移动了:"+speed);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}
	
	
}
