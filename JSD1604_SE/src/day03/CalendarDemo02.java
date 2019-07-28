package day03;

import java.util.Calendar;

/**
 * Calendar提供了针对不同时间分量单独设置值的方法
 * void set(int field, int value)
 * 其中第一个参数为:时间分量, 例如:年, 月, 日等等
 * 第二个参数为对应的值
 * 时间分量是一个int值, 使用Calendar提供的常量
 * @author Administrator
 *
 */
public class CalendarDemo02 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		
		//设置年
		calendar.set(Calendar.YEAR, 2017);
		System.out.println(calendar.getTime());
		
		//设置月 但是月是从0 开始的 输入8 显示九月 但是可以使用常量
		calendar.set(Calendar.MONTH, Calendar.AUGUST);
//		calendar.set(Calendar.MONTH, 7);
		System.out.println(calendar.getTime());
		
		//设置日
		/*
		 * 对应时间分量常用的:
		 * DATE:月中天
		 * DAY_OF_MONTH:月中的天, 月DATE一致
		 * DAY_OF_WEEK:周中的天, 星期几
		 * DAY_OF_YEAR: 年中的天
		 */
		calendar.set(Calendar.DAY_OF_MONTH, 8);
		System.out.println(calendar.getTime());
		calendar.set(Calendar.DAY_OF_WEEK, 1);
		System.out.println(calendar.getTime());
		calendar.set(Calendar.DAY_OF_YEAR, 180);
		System.out.println(calendar.getTime());
	}
}
