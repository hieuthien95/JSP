package kethua.shape;

public class Shape {
	int x, y;
	String color;
	String drawing(){
		return "Drawing shape";
	}
	public Shape(int x, int y, String color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}
	public Shape() {
		super();
	}
	@Override
	public String toString() {
		return "Shape [x=" + x + ", y=" + y + ", color=" + color + "]";
	}
}
