package cn.tedu.shoot;

public class World {
	Sky sky;
	Hero hero;
	Airplane a1;
	Airplane a2;
	BigAirplane ba1;
	BigAirplane ba2;
	Bee b1;
	Bee b2;
	Bullet bt1;
	Bullet bt2;
	
	void action() {		//测试代码
		sky = new Sky();
		hero = new Hero();
		a1 = new Airplane();
		a2 = new Airplane();
		ba1 = new BigAirplane();
		ba2 = new BigAirplane();
		b1 = new Bee();
		b2 = new Bee();
		bt1 = new Bullet(a1, 3);
		bt2 = new Bullet(a2, 6);
		
		sky.step();
		hero.step();
		a1.step();
		a2.step();
		ba1.step();
		ba2.step();
		b1.step();
		b2.step();
		bt1.step();
		bt2.step();
	}
	
	public static void main(String[] args) {
		World world = new World();
		world.action();
	}
}
