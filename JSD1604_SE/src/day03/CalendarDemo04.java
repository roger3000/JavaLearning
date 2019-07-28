package day03;

import java.util.Calendar;

/**
 * Calendar中计算时间的方法
 * void add(int field, int value )
 * @author Administrator
 *
 */
public class CalendarDemo04 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		//查看3年2个月零一天之后的日期?
		calendar.add(Calendar.YEAR, 3);
		calendar.add(Calendar.MONTH, 2);
		calendar.add(Calendar.DAY_OF_YEAR, 15);
		System.out.println(calendar.getTime());
		
		/*
		 * 当遇到类似开发需求
		 * 要求用户输入一个日期, 然后对该日期进行一系列的运算
		 * 再将计算后的日期显示给客户时
		 * 流程如下
		 * 1.获取用户输入的字符串
		 * 2.使用SimpleDateFormat将起转换为Date
		 * 3.创建一个Calendar, 使其表示Date显示的日期
		 * 4.使用Calendar根据需求计算时间
		 * 5.将Calendar转换为一个Date
		 * 6.使用SimpleDateFormat将Date转换为字符串后显示给用户
		 */
	}
}
