package day11;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo01 {
	public static void main(String[] args) {
//		print(1);
		print("1");
//		print('1');
	}
	
	public static void print(Object obj) {
		Class cls = obj.getClass();
		
		Field[] field = cls.getDeclaredFields();
		Method[] method = cls.getDeclaredMethods();
		for (int i = 0; i < field.length; i++) {
//			System.out.println(field[i]);
			System.out.println(method[i]);
		}
		System.out.println(cls);
		System.out.println(obj);
	}
}
