package abs.shape;

public class Rectangle extends Shape {
	private double w;
	private double l;

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public double getL() {
		return l;
	}

	public void setL(double l) {
		this.l = l;
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
		return w * l;
	}

	@Override
	public double getPerimeter() {
		return w + w + l + l;
	}

	@Override
	public String toString() {
		return "Rectangle [w=" + w + ", l=" + l + "]";
	}

	
	public Rectangle() {
		super();
	}

	public Rectangle(String color, boolean filled, double w, double l) {
		super(color, filled);
		this.w=w;
		this.l=l;
	}

	
}
