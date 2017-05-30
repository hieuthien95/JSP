package interfaces.point;

public class Rectangle extends Shape {
	private Point pointL;
	private Point pointR;

	public Point getPointL() {
		return pointL;
	}

	public void setPointL(Point pointL) {
		this.pointL = pointL;
	}

	public Point getPointR() {
		return pointR;
	}

	public void setPointR(Point pointR) {
		this.pointR = pointR;
	}

	public double getWidth() {
		return Math.abs(pointL.getX() - pointR.getX());
	}

	public double getHeight() {
		return Math.abs(pointL.getY() - pointR.getY());
	}

	public Rectangle() {
		super();
		pointL = new Point();
		pointR = new Point();
	}

	public Rectangle(String color, int ix, int iy, int iix, int iiy) {
		super(color, ix, iy);
		pointL = new Point(ix, iy);
		pointR = new Point(iix, iiy);
	}

	@Override
	public double getArea() {
		return getWidth() * getHeight();
	}

	@Override
	public void draw() {
		System.out.println("[]");

	}

	@Override
	public void moveTo(int ix, int iy) {
		pointL.setX(pointL.getX() + ix);
		pointL.setY(pointL.getY() + iy);

		pointR.setX(pointR.getX() + ix);
		pointR.setY(pointR.getY() + iy);

		draw();
	}

	@Override
	public void getInfo(Shape s) {
		System.out.println(((Rectangle) s).getPointL().getX() + ", "
				+ ((Rectangle) s).getPointL().getY() + ", "
				+ ((Rectangle) s).getPointR().getX() + ", "
				+ ((Rectangle) s).getPointR().getY() + ", "
				+ ((Rectangle) s).getArea());
	}

	@Override
	public String toString() {
		return "Rectangle [pointL=" + pointL + ", pointR=" + pointR + "]";
	}
	
}
