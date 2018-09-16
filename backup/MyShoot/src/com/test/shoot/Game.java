package com.test.shoot;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5652770692846797535L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 650;
	
	public static BufferedImage background;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage enemyplane;
	public static BufferedImage gameover;
	public static BufferedImage hero1;
	public static BufferedImage hero2;
	public static BufferedImage pause;
	public static BufferedImage start;
	
	public static Bullet[] bullets = {};
	public static FlyingObject[] flyings = {};
	public static Hero hero;
	
	Random rand = new Random();
	
	Game(){		
		hero = new Hero();
	}
	
	static {
		try {
			background = ImageIO.read(Game.class.getResource("background.png"));
			bee = ImageIO.read(Game.class.getResource("bee.png"));
			bullet= ImageIO.read(Game.class.getResource("bullet.png"));
			enemyplane = ImageIO.read(Game.class.getResource("enemyplane.png"));
			gameover = ImageIO.read(Game.class.getResource("gameover.png"));
			hero1 = ImageIO.read(Game.class.getResource("hero1.png"));
			hero2 = ImageIO.read(Game.class.getResource("hero2.png"));
			pause = ImageIO.read(Game.class.getResource("pause.png"));
			start = ImageIO.read(Game.class.getResource("start.png"));			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public FlyingObject nextOne(){
		
		if(rand.nextInt(10) <= 3){
			Bee b = new Bee();
			return b;
		}else{
			EnemyPlane ep = new EnemyPlane();
			return ep;
		}
	}
	int index=0;
	public void enterAction(){
		index++;
		if(index%40 == 0){
			flyings = Arrays.copyOf(flyings, flyings.length+1);
			flyings[flyings.length-1] = nextOne();
		}
	}
	
	public void stepAction(){

		for(int i=0;i < flyings.length; i++){
			flyings[i].step();
		}
		
		for(int i=0; i < bullets.length; i++){
			bullets[i].step();
		}
		
		hero.step();
	}
	
	int bulletsIndex = 0;
	public void bulletsAction(){
		bulletsIndex++;
		if(bulletsIndex % 30 == 0){
			Bullet[] bs = hero.shoot();
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length);
			for(int i=0; i < bs.length; i++){
				bullets[bullets.length-i-1] = bs[i];
			}
		}
		
	}
	
	public void outOfBoundAction(){
		FlyingObject[] fo = new FlyingObject[flyings.length];
		int index = 0;
		for(int i=0; i < flyings.length; i++){
			if(!flyings[i].outOfBound()){
				fo[index] = flyings[i];
				index++;
			}
		}
		flyings = Arrays.copyOf(fo, index);
		
		index = 0;
		Bullet[] bs = new Bullet[bullets.length];
		for(int i=0; i < bullets.length; i++){
			if(!bullets[i].outOfBound()){
				bs[index] = bullets[i];
				index++;
			}
		}
		bullets = Arrays.copyOf(bs, index);
	}
	
	public void action(){
		
		MouseAdapter l = new MouseAdapter() {
			public void mouseMoved(MouseEvent e){
				hero.setPos(e.getX()-hero.width/2, e.getY()-hero.height/2);
			}
		};
		
		this.addMouseListener(l);
		this.addMouseMotionListener(l);
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				enterAction();
				stepAction();
				bulletsAction();
				outOfBoundAction();
				repaint();
			}
			
		}, 10, 10);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintFlyingObject(g);
		paintHero(g);
		paintBullets(g);
	}
	public void paintFlyingObject(Graphics g) {
		for(int i=0; i < flyings.length; i++){
			FlyingObject f = flyings[i];
			g.drawImage(f.image, f.x, f.y, null);
		}
	}
	public void paintHero(Graphics g) {
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	public void paintBullets(Graphics g) {
		for(int i=0; i < bullets.length; i++){
			Bullet b = bullets[i];
			g.drawImage(b.image, b.x, b.y, null);
		}
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("JJ Fly");
		Game game = new Game();
		
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
		
		game.action();
	}
}
