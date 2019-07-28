package day08;
/**
 * 互斥锁
 * 当使用synchronized控制多段代码 
 * 而同步监视器    对象  相同    时, 这些代码之间就形成了互斥关系
 *  
 *  只要锁的是同一个对象 那么使用这个对象的代码都是互斥的
 *  
 * @author 许皓泉
 *
 */
public class SyncDemo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Boo b = new Boo();
		Thread t1 = new Thread() {
			public void run() {
				b.methodA();
			}
		};
		
		Thread t2  = new Thread() {
			public void run() {
				b.methodA();
			}
		};
		
		t1.start();
		t2.start();
	}

}

class Boo{
	public synchronized void methodA() {
		try {
			Thread t = Thread.currentThread();
			System.out.println("正在执行"+t.getName()+"方法");
			Thread.sleep(1000);
			
			System.out.println(t.getName()+"执行完毕");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}