package cn.tedu.shoot;

import java.util.Iterator;

//整个世界
public class World {
	Sky sky;
	Hero hero;
	FlyingObject[] enemies = new FlyingObject[9];
	Bullet[] bt = new Bullet[3];

	
	void action() {		//测试代码
		//生成主角机
		hero = new Hero();
		
		//生成敌机
		enemies[0] = new Airplane();
		enemies[1] = new Airplane();
		enemies[2] = new Airplane();

		
		//生成大敌机
		enemies[3] = new BigAirplane();
		enemies[4] = new BigAirplane();
		enemies[5] = new BigAirplane();
		
		//生成小蜜蜂
		enemies[6] = new Bee();
		enemies[7] = new Bee();
		enemies[8] = new Bee();
		
		//生成子弹
		bt[0] = new Bullet(hero, 3);
		bt[1] = new Bullet(hero, 3);
		bt[2] = new Bullet(hero, 3);
		
		//移动
		for (int i = 0; i < enemies.length; i++) {
			enemies[i].step();
		}
		
		//判断碰撞
//		for (int i = 0; i < enemies.length; i++) {
//			for (int j = 0; j < bt.length; j++) {
//				if(enemies[i].x == bt[j].x && enemies[i].y == bt[j].y) {
//					System.out.println("crashed!");
//				}
//			}
//		}

	}
	
	public static void main(String[] args) {
		World world = new World();			//创建世界
		world.action();
	}
}
