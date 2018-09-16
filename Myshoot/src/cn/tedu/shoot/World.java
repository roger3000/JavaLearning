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
		sky.height = 700;
		sky.width = 400;
		sky.x = 0;
		sky.y = 0;
		sky.speed = 10;
		sky.step();
	}
	
	public static void main(String[] args) {
		World world = new World();
		world.action();
	}
}
