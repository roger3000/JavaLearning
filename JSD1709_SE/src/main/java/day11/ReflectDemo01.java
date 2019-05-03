package day11;

import java.lang.reflect.Field;

public class ReflectDemo01 {
	public static void main(String[] args) {
		print(1);
		print("1");
		print('1');
	}
	
	public static void print(Object obj) {
		Class cls = obj.getClass();
		
		Field[] field = cls.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			System.out.println(field[i]);
		}
		System.out.println(cls);
		System.out.println(obj);
	}
}
