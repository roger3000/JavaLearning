package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 2.将当前系统时间以"yyyy-MM-dd HH:mm:ss"格式输出
 * 3.输入某人生日, 格式为"yyyy-MM-dd", 输出道现在为止经过了多少周
 * 4.输入一个生产日期格式为"yyyy-MM-dd",再输入一个数字(保质期)
 * 然后经过计算输出促销日期, 促销日期为: 该商品过期日前2周的周三
 * @author Administrator
 */
public class Exercise {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat( 
				"yyyy-MM-dd HH:mm:ss"
				);
		Date date = new Date();
		System.out.println("当前系统时间:"+sdf.format(date));
		
		//2.
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入生日:");
		String input = scan.nextLine();
		sdf = new SimpleDateFormat( 
				"yyyy-MM-dd"
				);
		date = sdf.parse(input);
		//now
		Date now = new Date();
		//计算时间差(ms)
		long during = now.getTime() - date.getTime();
		//计算周
		long duringWeek = during/1000/60/60/24/7;
		System.out.println("经过了"+duringWeek+"周");
		
		//4.
		System.out.println("输入生产日期");
		String madeIn = scan.next();
		System.out.println("输入保质期");
		int limit = scan.nextInt();
		date = sdf.parse(madeIn);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		//计算过期日期
		calendar.add(Calendar.DAY_OF_YEAR, limit);
		//计算促销日期
		calendar.add(Calendar.WEEK_OF_YEAR, -2);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		//输出促销日期
		date = calendar.getTime();
		System.out.println(sdf.format(date));
		
	}
}
