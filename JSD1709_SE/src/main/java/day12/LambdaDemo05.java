package day12;

/**
 * lambda中this的用法与匿名内部类不同 匿名内部类this 代表的是当前匿名内部类的实例 lambda中this代表的是外部类的实例
 * 
 * @author 许皓泉
 *
 */
public class LambdaDemo05 {
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.hello();
	}
}

class Demo {
	int b = 1;

	public void hello() {
		// 匿名内部类
		Too t1 = new Too() {
			int b = 6;

			@Override
			public void test(int a) {
				// TODO Auto-generated method stub
				System.out.println(a + this.b);
			}
		};
		t1.test(8);

		// lambda
		Too t2 = (a) -> {
			System.out.println(a + this.b);
		};
		t2.test(8);
	}
}

interface Too {
	void test(int a);
}