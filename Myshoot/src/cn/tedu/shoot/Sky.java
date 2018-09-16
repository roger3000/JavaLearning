package cn.tedu.shoot;
/**
 * 背景
 * @author roger
 *
 */
public class Sky {
	int width;
	int height;
	int x;
	int y;
	int speed;
	int y1;		//y1坐标(图片轮换)
	
	/**
	 * 天空移动
	 */
	void step() {
		System.out.println("天空的y坐标移动了:"+speed);
	}
}
