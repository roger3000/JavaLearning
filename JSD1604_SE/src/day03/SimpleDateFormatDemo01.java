package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.text.SimpleDateFormat
 * 根据一个给定的日期格式将String与Date相互转换
 * @author Administrator
 *
 */
public class SimpleDateFormatDemo01 {
	public static void main(String[] args) {
		/*
		 * d M y 日月年
		 * h m s 时分秒
		 * E 星期
		 */
		Date now = new Date();
		System.out.println(now);
		//2017-08-16 21:40:11
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ahh:mm:ss");
		/*
		 * Date --> String
		 * String format(Date date)
		 */
		String time = sdf.format(now);
		System.out.println(time);
		
		
	}
}
