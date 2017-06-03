package kethua.shape;

public class HinhTron extends Shape {
int r;
	
	double getCV(){
		return 2*3.14*r;
	}
	
	String drawing(){
		return "Drawing circle";
	}

	public HinhTron(int x, int y, String color, int r) {
		super(x, y, color);
		this.r = r;
	}

	public HinhTron() {
		super();
	}

	@Override
	public String toString() {
		return "HinhVuong [r=" + r + "]";
	}

}
