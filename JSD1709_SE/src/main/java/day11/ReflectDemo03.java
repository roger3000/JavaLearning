package day11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectDemo03 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("输入类名");
		String className = in.nextLine();
		try {
			Class cls = Class.forName(className);
			Object obj = cls.newInstance();
			
			Method[] methods = cls.getDeclaredMethods();
			for (Method method : methods) {
//				System.out.println(method);
				String name = method.getName();
//				System.out.println(name);
				if(name.startsWith("test")) {
					System.out.println(method);
					method.setAccessible(true); 
					method.invoke(obj);
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
