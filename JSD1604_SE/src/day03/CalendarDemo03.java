package day03;

import java.util.Calendar;

/**
 * 获取一个Calendar表示的日期中
 * 各个时间分量对应的值
 * @author Administrator
 *
 */
public class CalendarDemo03 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		/*
		 * int get(int field)
		 * 获取对应时间分量的值
		 */
		
		//获取年
		int year = calendar.get(Calendar.YEAR);
		System.out.println(year);
		
		//获取月
		int month = calendar.get(Calendar.MONTH);
		System.out.println(month+1);
		
		//获取日
		int day = calendar.get(Calendar.DATE);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		System.out.println(day+","+dayOfWeek+","+dayOfYear);
		
		//获取最大日期
		day = calendar.getActualMaximum(Calendar.DATE);
		dayOfWeek = calendar.getActualMaximum(Calendar.DAY_OF_WEEK);
		dayOfYear = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println(day+","+dayOfWeek+","+dayOfYear);
	}
}
