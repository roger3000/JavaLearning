package day03;

import java.util.Date;

/**
 * java.util.Date
 * Date的每一个实例用于表示一个确切的时间点
 * 内部维护了一个long值 该值记录的是从:
 * 1970/1/1 00:00:00 道表示的时间点之间所经历的
 * 毫秒值, 正数是70年以后的日期 负数是这70年以前的日期
 * 由于date设计存在缺陷(时区 千年虫), 所以java中该方法标注为过时的
 * @author Administrator
 * 
 */
public class DateDemo {
	public static void main(String[] args) {
		Date now = new Date();
		/*
		 * Date重写了tostring ,返回的字符串就是当前的时间
		 * Wed Aug 16 19:56:25 CST 2017
		 * 但是对非英语地区非常不友好
		 */
		System.out.println(now);
		/*
		 * Date的大部分方法都不建议使用了
		 */
		now.getDate();
		now.getYear();
		//except
		Long time = now.getTime();
		System.out.println(time);
		
		//明天这一刻的毫秒值
		time += 1000*60*60*24;
		/*
		 * void setTime(long time)
		 * 设置一个long值 使date表示该long值
		 * 所表示的时间
		 */
		now.setTime(time);
		System.out.println(now);
	}
}
