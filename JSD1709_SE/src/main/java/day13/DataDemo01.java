package day13;

import java.util.Calendar;
import java.util.Date;

public class DataDemo01 {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.getYear());
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		int sec = cal.get(Calendar.SECOND);
		int min = cal.get(Calendar.MINUTE);
		int hour = cal.get(Calendar.HOUR);
		System.out.println(hour+":"+min+":"+sec);
		
	}
}
