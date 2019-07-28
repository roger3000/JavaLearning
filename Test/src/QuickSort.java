import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	public static void quickSort(int[] a, int low,int high) {
		int l = low;
		int h = high;
		if(low>=high){
			return;
		}
		int std = a[low];
		while(l<h){
			while(l<h && a[h] <= std){
				h--;
			}
			while(l<h && a[l] >= std){
				l++;
			}
			if(l<h){
				int temp = a[l];
				a[l] = a[h];
				a[h] = temp;
			}
		}
		
		a[low] = a[l];
		a[l] = std;
		
		
		quickSort(a, low, l-1);
		
		quickSort(a, l+1, high);
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		int[] arr = new int[100000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(100000);
		}
		long star = System.currentTimeMillis();
//		quickSort(arr, 0, arr.length-1);
		Arrays.sort(arr);
		long end = System.currentTimeMillis();
		System.out.println(end-star);
	}
}
