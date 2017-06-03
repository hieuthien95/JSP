package kethua.shape1;

public class HinhVuong extends HinhCN {

	public void setSide(double d) {
		super.setLength(d);
		super.setWidth(d);
	}

	public double getSide() {
		return super.getWidth();
	}

	public HinhVuong() {
		super();
	}

	public HinhVuong(double side) {
		super(side, side);
	}

	public HinhVuong(String color, boolean filled, double side) {
		super(color, filled, side, side);
	}

	@Override
	public void setWidth(double side) {
		super.setWidth(side);
	}

	@Override
	public void setLength(double side) {
		super.setLength(side);
	}
	
	@Override
	public double getArea() {
		return getSide()*getSide();
	}

	@Override
	public String toString() {
		return "HinhVuong[" +getSide() + "]";
	}

}
