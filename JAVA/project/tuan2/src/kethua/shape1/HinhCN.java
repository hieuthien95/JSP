package kethua.shape1;

public class HinhCN extends Hinh {
	private double width, length;

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
		
	@Override
	public double getArea(){
		return width*length;		
	}
	
	public double getPerimeter(){
		return 0;
	}

	public HinhCN() {
		super();
	}

	public HinhCN(double width, double length) {
		this.width = width;
		this.length = length;
	}

	public HinhCN(String color, boolean filled, double width, double length) {
		super(color, filled);
		this.width = width;
		this.length = length;
	}

	@Override
	public String toString() {
		return "HinhCN[" + width + "," + length + "]";
	}

}
