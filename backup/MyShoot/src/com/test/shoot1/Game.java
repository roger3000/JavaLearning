package com.test.shoot1;

import java.awt.Color;
import java.awt.Font;
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

public class Game extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4114051705945596403L;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 654;
	
	public static final int START = 0;
	public static final int RUNNING = 1;
	public static final int PAUSE = 2;
	public static final int GAME_OVER = 3;
	
	public static BufferedImage background;
	public static BufferedImage bee;
	public static BufferedImage bullet;
	public static BufferedImage enemyplane;
	public static BufferedImage gameover;
	public static BufferedImage hero1;
	public static BufferedImage hero2;
	public static BufferedImage pause;
	public static BufferedImage start;
	
	private int delay;
	private int period;
	private int score;
	private int state;
	private Random rand;
	private FlyingObject[] flyings = {};
	private Bullet[] bullets = {};
	private Hero hero;
	
	Game(){
		delay = 10;
		period = 10;
		rand = new Random();
		hero = new Hero();
		state = START;
	}
	
	static{
		try {
			background = ImageIO.read(Game.class.getResource("background.png"));
			bee = ImageIO.read(Game.class.getResource("bee.png"));
			bullet = ImageIO.read(Game.class.getResource("bullet.png"));
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
		if(rand.nextInt(10) < 3){
			Bee bee = new Bee();
			return bee;
		}else{
			FlyingObject fo = new com.test.shoot1.EnemyPlane();
			return fo;
		}
	}
	
	int enterIntervel=0;
	public void enterAction(){
		enterIntervel++;
		if(enterIntervel % 40 == 0){
			FlyingObject fo = nextOne();
			flyings = Arrays.copyOf(flyings, flyings.length+1);
			flyings[flyings.length-1] = fo;
		}
	}
	
	public void stepAction(){
		for(int i=0; i < flyings.length; i++){
			flyings[i].step();
		}
		for(int i=0; i < bullets.length; i++){
			bullets[i].step();
		}
		hero.step();
	}
	
	int shootInterver = 0 ;
	public void shootAction(){
		shootInterver++;
		if(shootInterver % 30 ==0){
			Bullet[] bs = hero.shoot();
			bullets = Arrays.copyOf(bullets, bullets.length+bs.length);
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);
		}
	}
	
	public void exitAction(){
		FlyingObject[] fo = new FlyingObject[flyings.length];
		int index = 0;
		for(int i=0; i<flyings.length; i++){
			if(!flyings[i].outOfBound()){
				fo[index] = flyings[i];
				index++;
			}
		}
		flyings = Arrays.copyOf(fo, index);
		
		Bullet[] bs = new Bullet[bullets.length];
		index=0;
		for(int i=0; i<bullets.length; i++){
			if(!bullets[i].outOfBound()){
				bs[index] = bullets[i];
				index++;
			}
		}
		bullets = Arrays.copyOf(bs, index);
	}
	
	public void hitAction(){
		for(int i=0; i<bullets.length;i++){
			Bullet bs = bullets[i];
			hitPlane(bs);
		}
	}
	public void hitPlane(Bullet bs){
		int index = -1;
		for(int i=0; i < flyings.length; i++){
			FlyingObject fo = flyings[i];
			//击中了
			if(bs.hit(fo)){
				index = i;
				break;
			}
		}
		if(index != -1){
			FlyingObject temp = flyings[index];
			flyings[index] = flyings[flyings.length-1];
			flyings[flyings.length-1] = temp;
			flyings = Arrays.copyOf(flyings, flyings.length-1);
			if(temp instanceof Award){
				Award a = (Award)temp;
				int type = a.getAward();
				switch(type){
				case Award.DOUBLE_FIRE:
					hero.addDoubleFire();
					break;
				case Award.LIFE:
					hero.addLife();
					break;
				}
			}
			if(temp instanceof Enemy){
				score += 10;
			}
		}
	}

	public void crashAction(){
		int index = -1;
		for(int i=0; i < flyings.length; i++){
			FlyingObject fo = flyings[i];
			if(hero.crashedBy(fo)){
				hero.subtractLife();
				hero.clearDoubleFire();
				index = i;
			}
		}
		if(index != -1){
			FlyingObject temp = flyings[index];
			flyings[index] = flyings[flyings.length-1];
			flyings[flyings.length-1] = temp;
			flyings = Arrays.copyOf(flyings, flyings.length-1);
		}
	}
	
	public void isGameOver(){
		if(hero.getLife() <=0){
			state = GAME_OVER;
		}
	}
	
	public void action(){
		MouseAdapter l = new MouseAdapter() {
			public void mouseMoved(MouseEvent e){
				if(state == RUNNING){
					int x = e.getX()-hero.width/2;
					int y = e.getY()-hero.height/2;
					hero.moveTO(x, y);
				}
			}
			
			public void mouseClicked(MouseEvent e){
				if(state == START){
					state = RUNNING;
				}
				if(state == GAME_OVER){
					hero = new Hero();
					score = 0;
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
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				if(state == RUNNING){
					enterAction();
					stepAction();
					shootAction();
					exitAction();
					hitAction();
					crashAction();
					isGameOver();
					
				}
				repaint();
			}
			
		}, delay, period);
	}	
	
	@Override
	public void paint(Graphics g) {	
		g.drawImage(background, 0, 0, null);
		g.drawImage(hero.image, hero.x, hero.y, null);
		paintFlyings(g);
		paintBullets(g);
		paintScoreAndLife(g);
		paintState(g);
		
	}
	//遍历flyings,paint
	public void paintFlyings(Graphics g) {
		for(int i=0; i < flyings.length; i++){
			FlyingObject f = flyings[i];
			g.drawImage(f.image, f.x, f.y, null);
		}
	}
	
	public void paintBullets(Graphics g){
		for(int i=0; i < bullets.length; i++){
			Bullet b = bullets[i];
			g.drawImage(b.image, b.x, b.y, null);
		}
	}
	
	public void paintScoreAndLife(Graphics g){
		g.setColor(new Color(0xFF0000));
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		g.drawString("score:"+score, 10, 20);
		g.drawString("life:"+hero.getLife(), 10, 40);
	}
	
	public void paintState(Graphics g){
		switch(state){
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
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("FlyGame");
		Game game = new Game();
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.action();
	}

}
