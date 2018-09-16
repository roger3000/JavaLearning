package com.tarena.shoot;

import java.awt.image.BufferedImage;
import java.lang.reflect.Array;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;

public class ShootGame extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 654;
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;
	private int state = START;
	
	public static BufferedImage background;
	public static BufferedImage start;
	public static BufferedImage pause;
	public static BufferedImage gameover;
	public static BufferedImage airplane;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage hero0;
	public static BufferedImage hero1;
	
	private Hero hero = new Hero();
	private FlyingObject[] flyings = {};
	private Bullet[] bullets = {};
	
	ShootGame(){
		
	}
	
	static{		//静态块初始化静态资源
		try{
			background = ImageIO.read(ShootGame.class.getResource("background.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));
			airplane = ImageIO.read(ShootGame.class.getResource("enemyplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
			hero0 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero2.png"));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public FlyingObject nextOne(){
		Random rand = new Random();
		int type = rand.nextInt(100);
		if(type <= 6){
			return new Bee();
		}else{
			return new Airplane();
		}
	}
	
	int flyEnteredIndex = 0;
	public void enterAction(){
		flyEnteredIndex++;
		if(flyEnteredIndex % 20 == 0){
			FlyingObject one = nextOne();
			flyings = Arrays.copyOf(flyings, flyings.length+1);
			flyings[flyings.length-1] = one;
		}
	}

	public void stepAction(){
		hero.step();
		for(int i=0; i < flyings.length; i++){
			flyings[i].step();
		}
		for(int i=0; i < bullets.length; i++){
			bullets[i].step();
		}
	}
	
	int bulletsIndex = 0;
	public void shootAction(){
		bulletsIndex++;
		if(bulletsIndex % 20 == 0){
			Bullet[] bs = hero.shoot();
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length);
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);
		}
	}
	
	public void outOfBoundsAction(){
		FlyingObject[] flyingLives = new FlyingObject[flyings.length];
		Bullet[] bulletsLives = new Bullet[bullets.length];
		int index =0;
		for(int i=0; i < flyings.length; i++){
			FlyingObject f = flyings[i];
			if(!f.outOfBound()){
				flyingLives[index] = f;
				index++;
			}
		}
		flyings = Arrays.copyOf(flyingLives, index);
		index = 0;
		for(int i=0; i < bullets.length; i++){
			Bullet f = bullets[i];
			if(!f.outOfBound()){
				bulletsLives[index] = f;
				index++;
			}
		}
		bullets = Arrays.copyOf(bulletsLives, index);
	}
	
	public void bangAction(){
		for(int i=0; i < bullets.length; i++){
			Bullet b = bullets[i];
			bang(b);
		}
	}
	
	int score = 0;
	public void bang(Bullet b){
		int index=-1;
		for(int i=0; i < flyings.length; i++){			
			if(flyings[i].shootBy(b)){
				index = i;
				break;
			}
		}
		if(index != -1){
			FlyingObject fo = flyings[index];
			if(fo instanceof Enemy){
				Enemy e = (Enemy)fo;
				score += e.getScore();
			}
			if(fo instanceof Award){
				Award a = (Award)fo;
				int type = a.getType();
				switch(type){
				case Award.DOUBLE_FIRE:
					hero.addDoubleFire();
					break;
				case Award.LIFE:
					hero.addLife();
					break;
				}					
			}
			FlyingObject t = flyings[index];
			flyings[index] = flyings[flyings.length-1];
			flyings[flyings.length-1] = t;
			
			flyings = Arrays.copyOf(flyings, flyings.length-1);
		}
	}
	
	public void checkGameOverAction(){
		if(isGameOver()){
			state = GAME_OVER;
		}
	}
	public boolean isGameOver(){
		for(int i=0; i < flyings.length; i++){
			FlyingObject obj = flyings[i];
			if(hero.hit(obj)){
				hero.subtractLife();
				hero.clearDoubleFire();
				
				FlyingObject temp = flyings[i];
				flyings[i] = flyings[flyings.length-1];
				flyings[flyings.length-1] = temp;
				flyings = Arrays.copyOf(flyings, flyings.length-1);
			}
		}
		return hero.getLife() <= 0;
	}
	
	public void action(){
		MouseAdapter l = new MouseAdapter() {
			public void mouseMoved(MouseEvent e){
				if(state == RUNNING){
					hero.movedTo(e.getX()-hero.width/2, e.getY()-hero.height/2);
				}
			}
			
			public void mouseClicked(MouseEvent e){
				if(state == START){
					state = RUNNING;
				}
				if(state == GAME_OVER){
					score = 0;
					hero = new Hero();
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					state = START;
				}
			}
			
			public void mouseExited(MouseEvent e){
				if(state == RUNNING){
					state = PAUSE;
				}
			}
			
			public void mouseEntered(MouseEvent e){
				if(state != START){
					state = RUNNING;
				}
			}
		};
		this.addMouseListener(l);
		this.addMouseMotionListener(l);
		
		Timer timer = new Timer();
		int intervel = 10;
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				if(state == RUNNING){
					enterAction();
					stepAction();
					shootAction();
					outOfBoundsAction();
					bangAction();
					checkGameOverAction();
				}
				repaint();
			}
		}, intervel, intervel);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintHero(g);
		paintFlyingObjects(g);
		paintBullets(g);
		paintScoreAndLife(g);
		paintState(g);
	}
	public void paintHero(Graphics g) {
		g.drawImage(hero.image, hero.x, hero.y, null);
	}
	public void paintFlyingObjects(Graphics g) {
		for(int i=0; i<flyings.length; i++){
			FlyingObject f = flyings[i];
			g.drawImage(f.image, f.x, f.y, null);
		}
	}
	public void paintBullets(Graphics g) {
		for(int i=0; i < bullets.length; i++){
			Bullet b = bullets[i];
			g.drawImage(b.image, b.x, b.y, null);
		}
	}
	public void paintScoreAndLife(Graphics g) {
		g.setColor(new Color(0xFF0000));
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		g.drawString("score:"+score, 10, 20);
		g.drawString("life:"+hero.getLife(), 10, 40);
	}
	public void paintState(Graphics g) {
		switch(this.state){
		case START:
			g.drawImage(start, 0, 0, null);
			break;
		case RUNNING:
			break;
		case PAUSE:
			g.drawImage(pause, 0, 0, null);
			break;
		case GAME_OVER:
			g.drawImage(gameover, 0, 0, null);
			break;
		}
	}
	
	public static void main(String[] args){
		JFrame frame = new JFrame("fly");
		ShootGame game = new ShootGame();
		
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		game.action();
	}
}
