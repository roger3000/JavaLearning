package cn.tedu.shoot;

import javax.swing.JFrame;
import javax.swing.JPanel;

//整个世界
public class World extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 700;
	Sky sky = new Sky();
	Hero hero = new Hero();
	FlyingObject[] enemies = new FlyingObject[9];
	Bullet[] bt = new Bullet[2];

	
	void action() {		
		//天空
		sky.step();
		
		//英雄机
		hero.step();
		
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
		JFrame frame = new JFrame();
		World world = new World();
		frame.add(world);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);		//设置窗口居中
		frame.setVisible(true);
		
		world.action();
	}
}
