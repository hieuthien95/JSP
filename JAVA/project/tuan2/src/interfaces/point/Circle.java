package interfaces.point;

public class Circle extends Shape {
	private Point center;
	private int r;

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public Circle() {
		super();
		center = new Point();
	}

	public Circle(String scolor, int ix, int iy, int ir) {
		super(scolor, ix, iy);
		center = new Point(ix, iy);
		r = ir;
	}

	@Override
	public double getArea() {
		return 2 * Shape.PI * r * r;
	}

	@Override
	public void draw() {
		System.out.println("O");
	}

	@Override
	public void moveTo(int ix, int iy) {
		center.setX(ix);
		center.setY(iy);
		draw();
	}

	@Override
	public void getInfo(Shape s) {
		System.out.println(((Circle) s).getCenter().getX() + ", "
				+ ((Circle) s).getCenter().getY() + ", "
				+ ((Circle) s).getArea());
	}

	@Override
	public String toString() {
		return "Circle [center=" + center + ", r=" + r + "]";
	}

	

}
