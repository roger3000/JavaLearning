package day08;

public class HomeWork {
	public static void main(String[] args) {
		//�������һ�����飬 �ó�������Сֵ
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
		System.out.println("��СֵΪ"+min);
		
		int[] arr1 = generateArray(10, 200);
		for (int i : arr1) {
			System.out.print(i+" ");
		}
	}
	
	//ָ�����Ⱥʹ�С��������
	public static int[] generateArray(int len, int max) {
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*max);
		}
		return arr;
	}
}
