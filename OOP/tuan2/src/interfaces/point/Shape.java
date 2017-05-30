package interfaces.point;

public abstract class Shape {
	public static final double PI = 3.14;
	private String color;
	private Point startPoint;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Shape() {
		super();
		startPoint = new Point();
	}
	
	public Shape(int ix, int iy) {
		super();
		startPoint = new Point(ix, iy);
	}

	public Shape(String color, int ix, int iy) {
		super();
		this.color = color;
		startPoint = new Point(ix, iy);
	}
	
	public abstract double getArea();
	public abstract void draw();
	public abstract void moveTo(int ix, int iy);
	public abstract void getInfo(Shape s);
	public abstract String toString();
	

}
