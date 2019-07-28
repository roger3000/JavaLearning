package oo.day06;

public class ShapeTest {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[6];
		shapes[0] = new Circle(1);
		shapes[1] = new Circle(2);
		shapes[2] = new Square(1);
		shapes[3] = new Square(2);
		shapes[4] = new Six(1);
		shapes[5] = new Six(2);
		
		double max = shapes[0].area();
		for(Shape i : shapes){
			if(i.area() > max){
				max = i.area();
			}
		}
		
		System.out.println("the max is :"+max);
	}
}
