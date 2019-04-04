package day01;
/**
 * append 添加字符
 * delete 删除字符
 * insert 插入字符
 * replace 替换字符
 * charAt 查找某位置的字符
 * indexOf 查找指定字符
 * 
 * stringbuilder与stringbuffer的区别  
 * 	stringbuffer比较老 线程安全
 * 	stringbuilder比较新 不是线程安全 并发处理 速度较快
 * @author Administrator
 *
 */
public class StringBufferDemo {
	public static void main(String[] args) {
		//                                   01234567890
		StringBuffer str = new StringBuffer("Hello World");
		System.out.println(str);
		//append
		str.append("!!!");
		System.out.println(str);
		//表示范围都是含头不含尾的
		//delete
		str.delete(str.length()-3, str.length());
		System.out.println(str);
		//replace
		str.replace(6, str.length(), "mother fucker");
		System.out.println(str);
		//insert
		str.insert(6, "you ");
		System.out.println(str);
	}
}
