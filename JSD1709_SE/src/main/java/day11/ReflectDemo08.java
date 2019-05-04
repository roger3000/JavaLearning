package day11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo08 {
	public static void main(String[] args) {
		String className = "day11.Myservlet";
		Request req = new Request();
		Response res = new Response();
		
		ReflectDemo08 ref = new ReflectDemo08();
		try {
			
			ref.execute(className, req, res);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
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
	
	public void execute (String className, Request request, Response response) throws
	ClassNotFoundException, 
	NoSuchMethodException, 
	SecurityException, 
	InstantiationException, 
	IllegalAccessException, 
	IllegalArgumentException,
	InvocationTargetException {
		Class cls = Class.forName(className);
		Method method = cls.getMethod(className, Request.class, Response.class);
		Object obj = cls.newInstance();
		method.invoke(obj, request, response);
	}
}
