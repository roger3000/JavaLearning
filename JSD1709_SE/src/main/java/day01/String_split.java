package day01;

import java.util.Arrays;

/**
 * String[] split(regex)
 * 按照正则表达式拆分字符串
 * @author xhquan
 *
 */
public class String_split {
	public static void main(String[] args) {
		String str = "abc123dsfsdfsd45646dsdfdsf4646";
		/*
		 * 按照数字部分拆分
		 * 得到所有的字母
		 *
		 */
		String[] data = str.split("[0-9]+");
		System.out.println(Arrays.toString(data));
	}
}
