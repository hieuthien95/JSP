package interfaces.circle;

public class Circle implements IGeometricObject {
	protected double radius = 1;

	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getPerimerter() {
		return 0;
	}

	@Override
	public double getArea() {
		return 0;
	}

}
