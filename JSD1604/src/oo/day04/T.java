package oo.day04;

public class T extends Tetromino{
	//对成员变量的赋值都在构造方法中
	T(){
		this(0, 0);
	}
	
	T(int row, int col){
		cells[0] = new Cell(row, col);
		cells[1] = new Cell(row, col+1);
		cells[2] = new Cell(row, col+2);
		cells[3] = new Cell(row+1, col+1);
	}
}
