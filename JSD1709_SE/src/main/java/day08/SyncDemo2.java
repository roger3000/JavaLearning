package day08;
/**
 * 有效的缩小同步范围可以在保证并发安全的前提下提高并发效率
 * 
 * 同步块
 * 
 * synchronized
 * 
 * @author 许皓泉
 *
 */
public class SyncDemo2 {
	public static void main(String[] args) {
		final Shop shop = new Shop();
		
		Thread t1 = new Thread() {
			public void run() {
				shop.buy();
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				shop.buy();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Shop{
	public void buy() {
		try {
			Thread t = Thread.currentThread();
			System.out.println(t.getName()+"正在选衣服");
			Thread.sleep(5000);
			/*
			 * 若希望多个线程可以同步运行
			 * 必须保证同步监视器对象(上锁对象)(注意! 上锁的是 对象!对象!对象!)
			 * 是同一个
			 */
			synchronized (this) {
				
				System.out.println(t.getName()+"正在试衣服");
				Thread.sleep(5000);
			}
			
			System.out.println(t.getName()+"结账离开");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
