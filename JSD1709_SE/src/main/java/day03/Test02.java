package day03;
/**
 * 编写一段程序,完成1+2+3+4....+100并输出结果
 * 整段代码中,不得出现for while 关键字
 * @author xhquan
 *
 */
public class Test02 {
	public static void main(String[] args) {
		add(0,1);
	}
	
	public static void add(int result, int flag) {
		if(flag <=100) {
			result = result+flag;
			flag++;
			add(result,flag);
		}else {
			//递归不能使用return
			System.out.println(result);;
			
		}
		
		
		
	}
}
