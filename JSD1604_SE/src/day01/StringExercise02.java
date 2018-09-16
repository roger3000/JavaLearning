package day01;
/**
 * 输出所有的中文汉字 从\u4e00 - \u9fa5
 * @author Administrator
 *
 */
public class StringExercise02 {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		for(char c='\u4e00', i=1; c<'\u9fa5'; c++, i++){
			sb.append(c);
			if(i % 50==0){
				sb.append("\n");
			}
		}
		System.out.println(sb.length());
		System.out.println(sb);
	}
}
