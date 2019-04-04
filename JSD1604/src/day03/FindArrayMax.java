package day03;

import java.util.Scanner;


public class FindArrayMax {
	public static void main(String[] args) {
		int[] list = new int[3];
		System.out.println("请输入三个数");
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<3;i++){
			list[i]=scan.nextInt();
		}
		long star = System.currentTimeMillis();
		for(int i = 0;i<list.length;i++){
			for(int j = i;j<list.length;j++){
				if(list[i]<list[j]){
					int temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
		long end = System.currentTimeMillis();
		long time = end - star;
		System.out.println("time:"+time);
		System.out.println(list[0]);
	}
}
