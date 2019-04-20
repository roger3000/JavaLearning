package day08;

public class HomeWork {
	public static void main(String[] args) {
		//随机生成一个数组， 得出它的最小值
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100);
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
		
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println("最小值为"+min);
		
		int[] arr1 = generateArray(10, 200);
		for (int i : arr1) {
			System.out.print(i+" ");
		}
	}
	
	//指定长度和大小生成数组
	public static int[] generateArray(int len, int max) {
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*max);
		}
		return arr;
	}
}
