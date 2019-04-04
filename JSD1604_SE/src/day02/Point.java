package day02;
/**
 * 用来测试Object相关方法的重写
 * 该类的每一个实例表示直角坐标系上的一个点
 * 
 * 通常我们要使用tostring时, 就应该重写该方法
 * object自身定义的toString无意义,所以应该重写
 * 只有我们自身定义的类需要重写toString, JAVA API
 * 自带的类大部分都已经重写了toString
 * @author Administrator
 *
 */
public class Point {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Point(){
		
	}
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	//重写toString
	public String toString(){
		return x+","+y;
	}
	
	//重写equals,不重写默认使用"=="
	public boolean equals(Object obj){
		if(obj instanceof Point){
			Point p = (Point)obj;
			return (this.x==p.x)&&(this.y==p.y);
		}else{
			return false;
		}
	}
}
