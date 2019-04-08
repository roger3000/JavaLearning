package day01;

public class TestPoint {
	public static void main(String[] args) {
		Point p = new Point() {
			public String toString(){
				return Integer.toString(this.getX());
			}
			
			public boolean equals(Object obj) {
				return this.toString().equals(obj.toString());
			}
		};
		p.setX(1);
		
		Point p1 = new Point() {
			public String toString() {
				return Integer.toString(this.getX());
			}
		};
		p1.setX(1);
		
		System.out.println(p == p1);
		System.out.println(p.equals(p1));
		
		
	}
}
