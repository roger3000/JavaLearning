package day04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * java按照流读写数据的单位划分为：
 * 字节流 字符流
 * 字节流的单位是字节byte 字符流的单位是字符char
 * 字符流的实际底层还是以字节为单位读写，字符流会负责将字符于字节之间进行转换
 * 由于字符流以字符为单位读写，所以他们只适合读写文本数据
 * 
 * Reader Writer是所有字符输入，输出流的超类
 * 规定了字符流都应当具备的读写字符方法
 * 
 * 转换流
 * InputStreamReader，OutputStreamWriter
 * 他们之所以叫转换流，是因为java中其他的字符流只能接在字符流上
 * 不能够直接处理字节流
 * 而转换流是可以充当字符流和字节流的中间角色
 * @author 许皓泉
 *
 */

public class OSW_write {
	public static void main(String[] args) throws IOException{
		FileOutputStream fos =
				new FileOutputStream("osw.txt");
		
		OutputStreamWriter osw = 
				new OutputStreamWriter(fos);
		
		osw.write("好久没见了，什么角色呢");
		osw.write("细心装扮着，白色衬衫的");
		
		System.out.println("输出完毕");
		
		osw.close();
	}
}
