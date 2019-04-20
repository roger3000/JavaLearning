package day04;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * java标准IO input output
 * 流根据方向分为：
 * 输入流：读取数据
 * 输出流：写出数据
 * 
 * java将流分为两类
 * 节点流：又称为低级流，是建立再程序与数据源之间的管道，负责实际搬运数据的流
 * 			读写一定是建立再节点流之上的
 * 处理流：又称为高级流，特点是不能独立存在（没有意义），必须处理其他流，处理的目的是通过
 * 			它可以简化我们的读写操作
 * 
 * java.io.InputStream
 * java.io.OutputStream
 * 以上两个流是所有字节流的父类，定义了输入流与输出流必须具备的相关读写方法
 * 但他们本身是抽象类，不能直接使用
 * 
 * java.io.FileInputStream
 * 文件输入流，用来读取文件数据的流
 * 
 * java.io.FileOutputStream
 * 文件输出流，用来向文件中写出数据的流
 * 
 * @author roger
 *
 */
public class FOS_write{
	public static void main(String[] args) throws IOException{
		FileOutputStream fos = 
				new FileOutputStream("fos.txt");
		
		String str = "他不在和谁谈论相逢的孤岛";
		fos.write(str.getBytes());
		System.out.println("输出完毕");
		fos.close();
	}
}
