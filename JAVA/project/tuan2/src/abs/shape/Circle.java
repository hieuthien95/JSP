package abs.shape;

public class Circle extends Shape {
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getColor() {
		return super.getColor();
	}

	public void setColor(String color) {
		super.setColor(color);
	}

	public boolean isFilled() {
		return super.isFilled();
	}

	public void setFilled(boolean filled) {
		super.setFilled(filled);
	}

	@Override
	public double getArea() {
		return radius * radius * 3.14;
	}

	@Override
	public double getPerimeter() {
		return radius * 2 * 3.14;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

	public Circle() {
		super();
	}

	public Circle(String color, boolean filled, double radius) {
		super(color, filled);
		this.radius = radius;
	}

}
