package day11;

import java.util.Scanner;

public class ReflectDemo02 {
	public static void main(String[] args) {
		/*
		 * 利用反射api动态加载类到方法区
		 */
		
		Scanner in = new Scanner(System.in);
		System.out.println("输入类名");
		String className = in.nextLine();
		
		try {
			Class cls = Class.forName(className);
			System.out.println(cls);
			Object obj = cls.newInstance();
			System.out.println(obj);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
