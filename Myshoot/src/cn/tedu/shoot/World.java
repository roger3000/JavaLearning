package cn.tedu.shoot;

import java.util.Iterator;

//整个世界
public class World {
	Sky sky;
	Hero hero;
	Airplane[] ap;
	BigAirplane[] bap;
	Bullet[] bt;
	Bee[] bee;
	
	void action() {		//测试代码
		//生成主角机
		hero = new Hero();
		
		//生成敌机
		ap = new Airplane[3];
		ap[0] = new Airplane();
		ap[1] = new Airplane();
		ap[2] = new Airplane();
		for (Airplane airplane : ap) {
			System.out.println(airplane.x+","+airplane.y);
			airplane.step();
		}
		
		//生成大敌机
		bap = new BigAirplane[3];
		bap[0] = new BigAirplane();
		bap[1] = new BigAirplane();
		bap[2] = new BigAirplane();
		
		for (BigAirplane bigAirplane : bap) {
			bigAirplane.step();
		}
		
		//生成子弹
		bt = new Bullet[3];
		bt[0] = new Bullet(hero, 3);
		bt[1] = new Bullet(hero, 3);
		bt[2] = new Bullet(hero, 3);
		
		for (Bullet bullet : bt) {
			bullet.step();
		}
		
		//生成小蜜蜂
		bee = new Bee[3];
		bee[0] = new Bee();
		bee[1] = new Bee();
		bee[2] = new Bee();
		for (Bee bee : bee) {
			bee.step();
		}
	}
	
	public static void main(String[] args) {
		World world = new World();			//创建世界
		world.action();
	}
}
