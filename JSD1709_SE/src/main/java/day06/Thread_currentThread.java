package day06;
/**
 * 线程提供了一些API
 * 
 * 其中提供了一个静态方法
 * currentThread
 * @author HNL
 *
 */
public class Thread_currentThread {
	public static void main(String[] args) {
		Thread main = Thread.currentThread();
		System.out.println("运行main方法的线程是:"+main);
		
		dosome();
		
		Thread t = new Thread() {
			public void run(){
				Thread t = Thread.currentThread();
				System.out.println(t);
				dosome();
			}
		};
		
		t.start();
	}
	
	public static void dosome() {
		Thread t = Thread.currentThread();
		System.out.println("运行dosome方法的线程是:"+t);
	}
}
