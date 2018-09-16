package oo.day04;

import java.util.Random;
import java.util.Scanner;

public class TJTest {
	public static void main(String[] args) {
		Random rand = new Random();
		int ranCol = rand.nextInt(8);
		Scanner scan = new Scanner(System.in);
		T t = new T(0, ranCol);
		boolean flag = true;
		while(flag){
			System.out.println("1.退出  2.左 3.下 4.右");
			printWall(t);
			int c = scan.nextInt();
			switch (c) {
			case 1:
				flag = false;
				break;

			case 2:
				t.moveLeft();
				break;
			
			case 3:
				t.drop();
				break;
				
			case 4:
				t.moveRigth();
				break;
			}
		}
	}

	public static void printWall(Tetromino t){
		for(int i = 0;i < 20;i++){
			for(int j = 0;j < 10; j++){
				boolean flag = false;
				for(int k = 0; k < t.cells.length; k++){
					if(t.cells[k].row == i && t.cells[k].col == j){
						flag = true;
					}
				}
				if(flag == true){
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
}
