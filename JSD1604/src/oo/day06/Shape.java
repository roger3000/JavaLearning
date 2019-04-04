package oo.day06;

public abstract class Shape {
	int c;
	public abstract double area();
}

class Circle extends Shape {
	Circle(int c){
		this.c = c;
	}
	public double area(){
		return 0.0625*c*c;
	}
}

class Square extends Shape{
	Square(int c){
		this.c = c;
	}
	
	public double area(){
		return 0.0796*c*c;
	}
}

class Six extends Shape{
	Six(int c){
		this.c = c;
	}
	
	@Override
	public double area() {
		return 0.0721*c*c;
	}
}