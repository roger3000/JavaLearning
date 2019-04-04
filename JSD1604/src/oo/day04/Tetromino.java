package oo.day04;

abstract public class Tetromino{

	Cell[] cells = new Cell[4];
	
	void drop(){
		for(int i = 0;i < cells.length; i++){
			cells[i].row++;
		}
	}
	
	void moveLeft(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].col--;
		}
	}
	
	void moveRigth(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].col++;
		}
	}
	
	void getInfo(){
		for (int i = 0; i < cells.length; i++) {
			System.out.println(cells[i].getInfo());
		}
	}

}
