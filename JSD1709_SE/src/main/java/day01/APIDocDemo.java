package day01;
/**
 * 文档注释只修饰三个地方：
 * 类、方法、常量
 * 
 * 在类上修饰是用来说明当前类的设计意图，功能
 * 等信息说明
 * @author HNL
 * @version 1.0
 * @see java.lang.String
 * @since JDK1.5
 */
public class APIDocDemo {
	/**
	 * 问候语
	 */
	public static final String INFO = "你好";
	/**
	 * 为给定的用户添加问候语
	 * @param name
	 * @return 
	 */
	public static String sayHello(String name) {
		return INFO+name;
	}
}
