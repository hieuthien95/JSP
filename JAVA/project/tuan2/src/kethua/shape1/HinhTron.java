package kethua.shape1;

public class HinhTron extends Hinh {
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return radius * 3.14 * 2;
	}

	public double getPerimeter() {
		return 0;
	}

	public HinhTron() {
		super();
	}

	public HinhTron(String color, boolean filled, double radius) {
		super(color, filled);
		this.radius = radius;
	}

	public HinhTron(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "HinhTron[" + radius + "]";
	}

}
