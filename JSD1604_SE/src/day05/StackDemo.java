package day05;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 栈
 * 存储一组元素 存取受限
 * 先进后出 后进先出
 * 通常为了实现后退这类功能时会使用栈
 * @author Administrator
 *
 */
public class StackDemo {
	public static void main(String[] args) {
		/*
		 * 双端队列
		 * java.util.Deque
		 * 两端都可以进栈
		 * 当只调用一端进出队操作时, 就形成了栈
		 * 因此 双端队列为栈提供了两个方法
		 * push pop
		 */
		Deque<String> deque = new LinkedList<>();
		
		deque.push("one");
		deque.push("two");
		deque.push("three");
		deque.push("four");
		deque.push("five");
		
		System.out.println(deque);
		System.out.println(deque.pop());
		System.out.println(deque);
		
		//遍历
		while(deque.size()>0){
			System.out.println(deque.pop());
		}
		System.out.println(deque);
		
		int[] x = new int[25];
		System.out.println(x[24]);
	}
}
