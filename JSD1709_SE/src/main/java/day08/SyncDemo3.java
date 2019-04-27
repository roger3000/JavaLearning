package day08;


/**
 * 静态方法上使用synchronized
 * 那么该方法一定具有同步效果
 * @author 许皓泉
 *
 */
public class SyncDemo3 {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				Foo.dosome();
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				Foo.dosome();
			}
		};
		
		t1.start();
		t2.start();
	}

}

class Foo{
	public synchronized static void dosome() {
		Thread t = Thread.currentThread();
		try {
			System.out.println(t.getName()+"正在运行dosome方法");
			Thread.sleep(5000);
			
			System.out.println(t.getName()+"运行dosome方法完毕");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
