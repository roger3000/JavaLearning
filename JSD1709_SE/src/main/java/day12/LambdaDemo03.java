package day12;

public class LambdaDemo03 {
	public static void main(String[] args) {
		Koo k = ()->System.out.println("hello world");
		k.sayHello();
	}
}

/**
 * Functional功能性 Interface接口
 * java8提供了注解, 用于约束接口必须为功能性接口,即只能有一个方法
 * @author 许皓泉
 *
 */
@FunctionalInterface
interface Koo{
	public void sayHello();
}
