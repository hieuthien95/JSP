package kethua.point;

public class Point3D extends Point2D {
	private int z;

	public int getX() {
		return super.getX();
	}

	public void setX(int x) {
		super.setX(x);
	}

	public int getY() {
		return super.getY();
	}

	public void setY(int y) {
		super.setY(y);
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public Point3D() {
		super();
	}

	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	@Override
	public String toString() {
		return "Point3D(" + getX() + "," + getY() + "," + z + ") ";
	}

}
