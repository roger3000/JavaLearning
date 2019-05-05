package day12;

//lambda方法只能使用在功能性接口上
public class LambdaDemo01 {
	public static void main(String[] args) {
		Foo foo = (a, b)->a+b;
		Foo foo1 = (a,b)->{a++;b++;return a+b;};
		System.out.println(foo.test(5, 4));
		System.out.println(foo1.test(5, 4));
	}
}

interface Foo {
	public int test(int a, int b);
}
