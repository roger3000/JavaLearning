package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求用户输入自己的生日, 格式为:
 * 1992-07-13
 * 经过计算, 输出:
 * 到今天为止一共活了XXXX天
 * 以及距离10000天还有多少天
 * 生存10000天的纪念日是
 * @author Administrator
 *
 */
public class Test02 {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat( 
				"yyyy-MM-dd"
				);
		System.out.println("请输入生日:");
		String input = scan.nextLine();
		Date birthday = sdf.parse(input);
		Date now = new Date();
		
		long during = (now.getTime()-birthday.getTime())/1000/60/60/24;
		System.out.println("经历 了"+during+"天");
		
		System.out.println("距离10000天还有"+(10000-during)+"天");
		
		long time = (10000-during)*1000*3600*24;
		time = date.getTime()+time;
		date.setTime(time);
		
		System.out.println("10000天的纪念日是:"+sdf.format(date));
		
		
		scan.close();
	}
}
