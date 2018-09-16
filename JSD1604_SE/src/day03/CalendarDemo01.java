package day03;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Calendar
 * 日历类
 * 该类是一个抽象类, 封装了对时间的相关操作
 * 常用的实现类是格里高利历(阳历)
 * 使用日历类是为了对时间进行相关的操作
 * 比如计算时间
 * @author Administrator
 *
 */
public class CalendarDemo01 {
	public static void main(String[] args) {
		/*
		 * 使用Calendar的静态方法创建实例
		 * 该方法会根据当前系统所在地区创建一个相应的实现
		 * 通常是格里高利历
		 * 默认创建的日历实例表示当前系统时间
		 */
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat( 
				"yyyy-MM-dd HH:mm:ss"
				);
		//toString不能直观反映表示的日期
		System.out.println(calendar);
		
		/*
		 * Calendar 与 Date 之间的转换
		 * 
		 * 
		 * Calendar -> Date
		 * Calendar提供了一个方法 getTime() 
		 * 返回一个Date对象 该对象表示的时间就是
		 * 当前Calendar表示的时间
		 * 
		 */
		Date date = calendar.getTime();
		System.out.println(sdf.format(date));
		
		//表示明天这一时刻
		date.setTime(date.getTime()+1000*3600*24);
		System.out.println(sdf.format(date));
		
		/*
		 * Date -> Calendar
		 * void setTime(Date date)
		 * Calendar的setTime方法可以使当前
		 * Calendar表示的给定的Date说表示的时间
		 */
		//Calendar也表示明天这一刻了
		calendar.setTime(date);
		System.out.println(calendar);
	}
}
