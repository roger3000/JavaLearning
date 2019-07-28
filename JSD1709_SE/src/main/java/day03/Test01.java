package day03;
/**
 * 买汽水,一块钱一瓶汽水,2个空瓶可以换一瓶汽水,3个瓶盖可以换一瓶汽水
 * 问 20块钱总共可以买多少瓶汽水
 * @author xhquan
 *
 */
public class Test01 {
	public static void main(String[] args) {
		cal(20, 0, 0, 0);
	}
	/**
	 * 
	 * @param num1 金钱数
	 * @param num2 空瓶数
	 * @param num3 瓶盖数
	 * @param num4 总数
	 */
	public static void cal(int num1,int num2,int num3,int num4) {
		num1--;
		num2++;
		num3++;
		num4++;
		
		if(num2 % 2 == 0) {
			num4++;
		}
		if(num3 % 3 == 0) {
			num4++;			
		}
		if(num1 > 0) {
			cal(num1, num2, num3, num4);
		}else {
			System.out.println(num1+"v"+num4);
		}
	}
}
