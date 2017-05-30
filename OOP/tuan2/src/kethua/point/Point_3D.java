package kethua.point;

public class Point_3D {
	private Point2D p;
	private int z;

	public int getX() {
		return p.getX();
	}

	public void setX(int x) {
		p.setX(x);
	}

	public int getY() {
		return p.getY();
	}

	public void setY(int y) {
		p.setY(y);
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public Point_3D() {
		super();
		p=new Point2D();
	}

	public Point_3D(int x, int y, int z) {
		super();
		p=new Point2D();
		p.setX(x);
		p.setY(y);
		this.z = z;
	}

	@Override
	public String toString() {
		return "Point_3D(" + getX() + "," + getY() + "," + z + ") ";
	}

}
