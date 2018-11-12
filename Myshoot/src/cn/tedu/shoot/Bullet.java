package cn.tedu.shoot;
/**
 * 子弹
 * @author roger
 *
 */
public class Bullet extends FlyingObject {

	int speed;
	
	Bullet(Hero hero, int speed){
		this.x = hero.x;
		this.y = hero.y;
		width = 8;
		height = 14;
		this.speed = speed;
	}
	
	/**
	 * 子弹移动
	 */
	void step() {
		System.out.println("子弹的y坐标动了"+speed);
	}
}
