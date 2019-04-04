package day01;
/**
 * 字符串的常量池
 * JVN在对内存中开辟了一块区域保存曾经使用字面量形式创建过的字符串常量
 * 一旦后期又使用字面量创建，则会重用而不会再创建新对象
 * 节省内存开销
 * @author roger
 *
 */
public class StringDemo {
	public static void main(String[] args) {
//		String str = "hello world";
//		str = str + "!";
		
		String s1 = "123abc";
		//s2重用s1创建的对象
		String s2 = "123abc";
		System.out.println(s1 == s2);
		/**
		 * 编译器有一个优化措施：
		 * 但一个计算表达式的计算符号两边是字面量时
		 * 编译器会直接计算并将结果编译到class文件中
		 * 所以虚拟机再执行下面语句时
		 * 实际看到的代码是：
		 * String s4 = “123abc”；
		 * 那么就直接重用s1对象了
		 */
		String s3 = "123"+"abc";
		
		/**
		 * 修改字符串会直接创建新对象
		 */
		String s = "123";
		//虽然s4也是“123abc” 但是是新的对象
		String s4 = s + "abc";
		
		System.out.println(s2 == s3);
		System.out.println(s3 == s4);
	}
}
