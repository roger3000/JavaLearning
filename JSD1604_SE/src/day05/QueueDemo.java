package day05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * java.util.Queue
 * 队列
 * 存取受限
 * 遵循先进先出的数据结构
 * @author Administrator
 *
 */
public class QueueDemo {
	public static void main(String[] args) {
		//队列使用LinkedList实现
		Queue<String> q = new LinkedList<>();
		
		/*
		 * boolean offer(E e)
		 * 入队操作 向队尾追加一个新元素
		 */
		q.offer("one");
		q.offer("two");
		q.offer("three");
		q.offer("four");
		
		System.out.println(q);
		/*
		 * 出队操作
		 * E poll()
		 * 从队首获取元素
		 * 获取成功后就从队列里删除了
		 */
		String str = q.poll();
		System.out.println(str);
		System.out.println(q);
		
		/*
		 * E peek()
		 * 引用队首元素 但是不做出队操作
		 */
		System.out.println(q.peek());
		System.out.println(q);
		
		//遍历 倒着来
//		for(int i = q.size(); i>0; i--){
//			String str1 = q.poll();
//			System.out.println(str1);			
//		}
		//while 更好用
		while (q.size()>0) {
			String str1 = q.poll();
			System.out.println(str1);
		}
	}
}
