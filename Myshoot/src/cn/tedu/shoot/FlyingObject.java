package cn.tedu.shoot;

import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/** 飞行物*/
public class FlyingObject {
	protected int height;
	protected int width;
	protected int x;
	protected int y;
	
	public FlyingObject() {
	}
	
	public FlyingObject(int width, int height) {
		this.width = width;
		this.height = height;
		x = new Random().nextInt(World.WIDTH-this.width);
		y = -height;
	}
	
	public FlyingObject(int width, int height, int x, int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	
	//飞行物移动
	public void step() {
		System.out.println("飞行物移动了");
	}
	
	//加载读取图片
	public static BufferedImage loadImage(String filename) {
		try {
			BufferedImage image = ImageIO.read(FlyingObject.class.getResource(filename));	//这种方式只能同包中读取
			return image;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}	
	}
}
