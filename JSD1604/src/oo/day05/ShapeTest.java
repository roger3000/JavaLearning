package oo.day05;
//找一组图形中的最大面积
public class ShapeTest {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[6];
		shapes[0] = new Square(1);
		shapes[1] = new Square(2);
		shapes[2] = new Square(3);
		shapes[3] = new Circle(1);
		shapes[4] = new Circle(2);
		shapes[5] = new Circle(3);
		
		getMax(shapes);
		
	}
	
	public static void getMax(Shape[] s){
		double max = s[0].area();
		for(Shape i : s){
			if(i.area() > max){
				max = i.area();
			}
		}
		
		System.out.println("the max is:"+max);
	}
}

abstract class Shape{
	protected int c;
	
	public abstract double area();
}

class Square extends Shape{
	public Square(int c) {
		this.c = c;
	}
	@Override
	public double area() {
		return 0.0625*c*c;
	}
}

class Circle extends Shape{
	public Circle(int c) {
		this.c = c;
	}
	@Override
	public double area() {
		return 0.0796*c*c;
	}
}