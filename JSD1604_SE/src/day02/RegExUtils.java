package day02;
/**
 * 实现对身份证号码、邮政编码、手机号码的合法性校验
 * @author Administrator
 *
 */
public class RegExUtils {
	//验证身份证
	public static boolean idCheck(String str){
		String regex = "[\\d]{18}";
		return str.matches(regex);
	}
	//验证邮编
	public static boolean postalCodeCheck(String str){
		String regex = "[\\d]{6}";
		return str.matches(regex);
	}
	//验证手机号
	public static boolean phoneNumCheck(String str){
		String regex = "1[\\d]{10}";
		return str.matches(regex);
	}
}
