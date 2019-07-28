package day06;

public class ThreadDemo03 {
	public static void main(String[] args) {
		//直接继承线程方式
		Thread t1 = new Thread(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 1000; i++) {
					System.out.println("我是查水表的");
				}
			}
		});
		
		t1.start();
		
	}
}
