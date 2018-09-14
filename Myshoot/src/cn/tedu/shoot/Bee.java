package cn.tedu.shoot;

public class Bee {
	int width;
	int height;
	int x;
	int y;
	int xSpeed;
	int ySpeed;
	int awardType;
	
	void step() {
		System.out.println("小蜜蜂的x坐标移动了："+xSpeed);
		System.out.println("小蜜蜂的y坐标移动了："+ySpeed);
	}
}
