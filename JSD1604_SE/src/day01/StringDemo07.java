package day01;
/**
 * 字符串拼接性能问题
 * String因为重用问题所以不能修改 只能创建新对象
 * StringBuffer 可以修改,不能像String一样重用
 * 
 * @author Administrator
 *
 */
public class StringDemo07 {
	public static void main(String[] args) {
		String str = "a";
		StringBuffer strB = new StringBuffer(str);
		long start = System.currentTimeMillis();
		//string拼接
		for(int i=0; i<100000; i++){
			str+="a";
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		//stringbuffer拼接
		long startB = System.currentTimeMillis();
		for(int i=0; i<100000; i++){
			strB.append("a");
		}
		long endB = System.currentTimeMillis();
		System.out.println(strB.substring(0, 20));
		System.out.println(endB-startB);
		
		
	}

}
