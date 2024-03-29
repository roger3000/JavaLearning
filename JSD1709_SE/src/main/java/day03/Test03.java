package day03;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 完成用户注册功能 程序启动后，要求该用户输入注册信息 格式如： 刘苍松，55，男，5000.2008-08-04 然后将该用户的信息输入到emp.dat
 * 
 * @author roger
 *
 */
public class Test03 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf = new RandomAccessFile("emp.dat", "rw");
		boolean flag = true;
		String regex = ".{2},\\d{2},[男女],\\d{4},\\d{4}-[0][0-9]|.{2},\\d{2},[男女],\\d{4},\\d{4}-[1][0-2]-[0]\\d|.{2},\\d{2},[男女],\\d{4},\\d{4}-[0-2][0-9]|.{2},\\d{2},[男女],\\d{4},\\d{4}-[1][0-2]-[3][0-1]";
		Scanner sc = new Scanner(System.in);

		while (flag) {

			System.out.println("请输入注册信息：");
			String str = sc.nextLine();
			String[] strr = str.split(",");
//			System.out.println(strr.length);
//			System.out.println(Arrays.toString(strr));
			raf.seek(raf.length());
			if (str.matches(regex)) {
				flag = false;
				writeRaf(raf, strr[0], 32);
				writeRaf(raf, strr[1], 4);
				writeRaf(raf, strr[2], 10);
				writeRaf(raf, strr[3], 4);
				writeRaf(raf, strr[4], 30);
				System.out.println("注册成功");
			} else {
				System.out.println("输入格式有误，请重新输入");
			}
		}

		sc.close();
		raf.close();
	}

	public static void writeRaf(RandomAccessFile raf, String str, int len) throws IOException {
		byte[] data = str.getBytes("UTF-8");
		data = Arrays.copyOf(data, len);
		raf.write(data);
		;
	}
}
