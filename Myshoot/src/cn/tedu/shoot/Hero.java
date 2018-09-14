package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Hero {
	int height;
	int width;
	int x;
	int y;
	int life;
	int doubleFire;
	BufferedImage image ;
	
	void moveTo(int x, int y) {
		this.x = x-(width/2);
		this.y = y-(height/2);
	}
	
	void step() {
		System.out.println("Ó¢ÐÛ»úÇÐ»»Í¼Æ¬À²");
	}
}
