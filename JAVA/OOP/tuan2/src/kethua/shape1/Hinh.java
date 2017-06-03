package kethua.shape1;

public class Hinh {
	private String color;
	private boolean filled;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public Hinh(String color, boolean filled) {
		super();
		this.color = color;
		this.filled = filled;
	}

	public Hinh() {
		super();
	}
	
	public double getArea(){
		return 0;		
	}

	@Override
	public String toString() {
		return "Shape[" + color + "," + filled + "]";
	}

}
