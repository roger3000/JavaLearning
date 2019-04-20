package oo.day03;

public class RefArrayDemo {
	public static void main(String[] args) {
		Student[] stus = new Student[3];
		stus[0] = new Student("zhangsan",25,"廊坊");
		stus[1] = new Student("lisi",26,"JMS");
		stus[2] = new Student("wangwu", 27, "SD");
		
		Student[] ss = new Student[] {
				new Student("zhangsan",25,"廊坊"),
				new Student("lisi",26,"JMS"),
				new Student("wangwu",27,"SD")
		};
		
		int[][] arr = new int[3][];
		arr[0] = new int[2];
		arr[1] = new int[3];
		arr[2] = new int[2];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = 100;
			}
		}
	}
}
