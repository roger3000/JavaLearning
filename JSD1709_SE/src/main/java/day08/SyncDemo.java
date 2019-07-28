package day08;
/**
 * 多线程并发安全问题
 * 当多个线程并发操作同一资源时
 * 由于线程切换时机不确定, 可能会导致代码执行混乱从而导致程序出现错误, 严重时可能导致系统瘫痪
 * 
 * 
 * @author 许皓泉
 *
 */
public class SyncDemo {

	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+","+bean);
				}
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				while(true) {
					int bean = table.getBean();
					Thread.yield();
					System.out.println(getName()+":"+bean);
				}
			}
		};
		
		t1.start();
		t2.start();
	}

}

class Table{
	private int beans = 20;
	
	public synchronized int getBean() {
		if(beans == 0) {
			throw new RuntimeException("豆子没了");
		}
		Thread.yield();
		return beans--;
	}
}