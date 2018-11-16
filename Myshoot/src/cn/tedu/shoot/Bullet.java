package cn.tedu.shoot;
/**
 * 子弹
 * @author roger
 *
 */
public class Bullet extends FlyingObject {

	private int speed;
	
	Bullet(Hero hero, int speed){
		super(8, 14, hero.x, hero.y);
		this.speed = speed;
	}
	
	/**
	 * 子弹移动
	 */
	public void step() {
		System.out.println("子弹的y坐标动了"+speed);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
}
