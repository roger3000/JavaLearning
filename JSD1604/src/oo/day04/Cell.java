package oo.day04;

public class Cell {
	
	int row;
	int col;
	
	Cell(){
		this(0,0);
	}
	
	Cell(int row, int col){
		this.row = row;
		this.col = col;
	}
	
	String getInfo(){
		return row+","+col;
	}

}
