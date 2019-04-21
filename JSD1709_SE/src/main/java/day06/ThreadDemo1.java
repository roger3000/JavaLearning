package day06;
/**
 * 多线程
 * 线程可以让我们"同时"运行多端代码
 * 线程运行代码是并发的,并不是真正的同时运行
 * 
 * 线程有两种创建方式
 * 1. 继承Thread并重写run方法, 在run方法中
 * 定义线程要执行的任务
 * 2. 实现Runnable接口
 * @author 许皓泉
 *
 */
public class ThreadDemo1 {
	public static void main(String[] args) {
		Thread t1 = new MyThread("你是谁啊");
		Thread t2 = new MyThread("我是查水表的");
		
		t1.start();
		t2.start();
		
	}
}

class MyThread extends Thread{
	String str;
	public MyThread(String str) {
		this.str = str;
	}
	public void run(){
		for (int i = 0; i < 10000; i++) {
			System.out.println(str);
		}
	}
}