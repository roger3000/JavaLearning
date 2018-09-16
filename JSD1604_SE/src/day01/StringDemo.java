package day01;

public class StringDemo {
	public static void main(String[] args) {
		/**
		 * String 有final属性 不可更改 只能产生新的String
		 * 对象. 使用"==" 会对比两个string的内存地址, 当
		 * 内存中已经存有相同string时, 会默认引用内存抵制
		 * 但是并不是绝对的
		 */
		StringBuffer str1 = new StringBuffer("hello");
		//使用直接量“字符序列”的方式创建字符串对象缓存在 常量池 中
		String str2 = "World";
		
		String str3 = "Hello"+str2;
		String str4 = "Hello"+"World";
		String str5 = str1+str2;
		String str6 = "HelloWorld";
		
		System.out.println(str6==str4);
		System.out.println(str6==str5);
		System.out.println(str6==str3);
		
	}
}
