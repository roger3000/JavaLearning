package day05;
/**
 * 该类用于作为集合的元素
 * 
 * @author Administrator
 *
 */
public class Point implements Comparable<Point> {
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
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	public boolean equals(Object o){
		if(o instanceof Point){
			Point p = (Point)o;
			if(p.x == this.y && p.y == this.y){
				return true;
			}
		}
		return false;
	}
	/**
	 * 当实现了Comparable接口后 需要重写下面的方法
	 * 该方法的作用是定义当前对象与给定对象参数对象比较大小的规则
	 * 返回值是int 该值表示大小关系 它不关注具体的取值是多少 
	 * 而关注的是取值范围
	 * >0 当前对象比参数对象大
	 * <0 当前对象比参数对象小
	 * =0 当前对象与参数对象相等
	 */
	public int compareTo(Point o) {
		int len1 = this.x*this.x+this.y*this.y;
		int len2 = o.x*o.x+o.y+o.y;
		return len1-len2;
	}
}
