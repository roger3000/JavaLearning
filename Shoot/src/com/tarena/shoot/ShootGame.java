
package com.tarena.shoot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShootGame extends JPanel {
	public static final int WIDTH = 400; // ����
	public final static int HEIGHT = 654; // ����
	public static BufferedImage background;
	public static BufferedImage start;
	public static BufferedImage enemyplane;
	public static BufferedImage bee;
	public static BufferedImage hero1;
	public static BufferedImage hero2;
	public static BufferedImage pause;
	public static BufferedImage gameover;
	public static BufferedImage bullet;

	static { // ��̬������ʼ������ͼƬ
		try {
			background = ImageIO.read(ShootGame.class
					.getResource("background.png"));
			start = ImageIO.read(ShootGame.class.getResource("start.png"));
			enemyplane = ImageIO.read(ShootGame.class
					.getResource("enemyplane.png"));
			bee = ImageIO.read(ShootGame.class.getResource("bee.png"));
			hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));
			hero2 = ImageIO.read(ShootGame.class.getResource("hero2.png"));
			pause = ImageIO.read(ShootGame.class.getResource("pause.png"));
			gameover = ImageIO
					.read(ShootGame.class.getResource("gameover.png"));
			bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Hero hero; // Ӣ�ۻ�
	private FlyingObject[] flyings; // �л�����
	private Bullet[] bullets; // �ӵ�����

	public ShootGame() {
		/** ��ʼ��Ӣ�ۻ�,һֻ�۷��һ�ܷɻ� */
		hero = new Hero();
		flyings = new FlyingObject[2];
		flyings[0] = new EnemyPlane();
		flyings[1] = new Bee();
		/** ��ʼ��һ���ӵ� */
		bullets = new Bullet[1];
		bullets[0] = new Bullet(200, 350);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null); // ������ͼ
		paintHero(g); // ��Ӣ�ۻ�
		paintBullets(g); // ���ӵ�
		paintFlyingObjects(g); // ��������
	}

	/** ��Ӣ�ۻ� */
	public void paintHero(Graphics g) {
		g.drawImage(hero.getImage(), hero.getX(), hero.getY(), null);
	}

	/** ���ӵ� */
	public void paintBullets(Graphics g) {
		for (int i = 0; i < bullets.length; i++) {
			g.drawImage(bullets[i].getImage(), bullets[i].getX(),
					bullets[i].getY(), null);
		}
	}

	/** �������� */
	public void paintFlyingObjects(Graphics g) {
		for (int i = 0; i < flyings.length; i++) {
			g.drawImage(flyings[i].getImage(), flyings[i].getX(),
					flyings[i].getY(), null);
		}
	}

	/**
	 * ������ɷ�����
	 * 
	 * @return ���������
	 */
	public static FlyingObject nextOne() {
		Random rand = new Random();
		int type = rand.nextInt(20);
		if (type == 0)
			return new Bee();
		else
			return new EnemyPlane();
	}

	private int flyEnteredIndex = 0; // �������볡����

	/** �������볡 */
	public void enterAction() {
		flyEnteredIndex++;
		if (flyEnteredIndex % 50 == 0) {
			this.flyings = Arrays.copyOf(this.flyings, this.flyings.length + 1);
			this.flyings[this.flyings.length - 1] = nextOne();
		}
	}

	/** �������ƶ� */
	public void stepAction() {
		/** ��������һ�� */
		for (int i = 0; i < this.flyings.length; i++)
			this.flyings[i].step();

		/** �ӵ���һ�� */
		for (int i = 0; i < this.bullets.length; i++)
			this.bullets[i].step();
	}

	private Timer timer; // ��ʱ��
	private int interval = 1000 / 100; // ʱ����

	public void action() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				enterAction();
				stepAction();
				repaint();
			}
		}, interval, interval);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Fly");
		ShootGame game = new ShootGame(); // ������
		frame.add(game); // �������ӵ�JFrame��
		frame.setSize(ShootGame.WIDTH, ShootGame.HEIGHT); // ��С
		frame.setAlwaysOnTop(true); // ������������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ĭ�Ϲرղ���
		frame.setLocationRelativeTo(null); // ���ô����ʼλ��
		frame.setVisible(true); // �������paint
		game.action();
	}
}
