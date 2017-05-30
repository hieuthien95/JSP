package circle;

public class Circle {
	public static final double PI = 3.14;
	private int r;
	private static int count =0;
	
	public static double getPi() {
		return PI;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public Circle(int r) {
		super();
		this.r = r;
		count++;
	}
	public Circle() {
		super();
		this.r=0;
		count++;
	}
	@Override
	public String toString() {
		return "Circle [r=" + r + "]";
	}
	
	public double getCV(){
		return 2*PI*r;
	}
	
	public static int getNumberOfCircles(){
		return count;
	}
	
	//Không thể tạo hàm static để getCV đường tròn vì r không static

}
