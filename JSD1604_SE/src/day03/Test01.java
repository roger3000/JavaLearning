package day03;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 查看当前系统时间和16天5小时23分40秒以后的日期'
 * 显示的格式:
 * 2016年05月25日 hh:mm:ss
 * @author Administrator
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy年MM月dd日 HH:mm:ss"
				);
		System.out.println(sdf.format(date));
		//16天5小时23分40秒以后的日期
		long time = date.getTime();
		time += 16*1000*3600*24;
		time += 5*1000*60*60;
		time += 23*1000*23;
		time += 40*1000;
		date.setTime(time);
		System.out.println(sdf.format(date));
	}
}
