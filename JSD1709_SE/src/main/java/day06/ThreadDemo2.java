package day06;

public class ThreadDemo2 {
	public static void main(String[] args) {
		Runnable r1 = new MyRunnable01();
		Runnable r2 = new MyRunnable02();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}
}

class MyRunnable01 implements Runnable{

	public void run() {
		for(int i=0;i < 1000; i++) {
			System.out.println("你好啊");
		}
	}
	
}

class MyRunnable02 implements Runnable{

	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("我不好");
		}
	}
	
}