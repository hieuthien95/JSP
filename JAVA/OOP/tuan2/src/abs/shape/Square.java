package abs.shape;

public class Square extends Rectangle {
	public double getSide() {
		return super.getL();
	}

	public void setSide(double l) {
		super.setL(l);
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

	public void setW(double w) {
		super.setW(w);
	}

	public void setL(double l) {
		super.setL(l);
	}

	@Override
	public String toString() {
		return "Square [" + getSide() + "]";
	}

	public Square() {
		super();
	}

	public Square(String color, boolean filled, double r) {
		super(color, filled, r, r);
	}

	
}
