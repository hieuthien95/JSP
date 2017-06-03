package kethua.point;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Point2D p2d = new Point2D(1, 2);
		Point3D p3d = new Point3D(2, 3, 4);
		Point_3D p_3d = new Point_3D(3, 4, 5);

		ArrayList<Point2D> dsPoint = new ArrayList<>();
		dsPoint.add(p2d);
		dsPoint.add(p3d);

		ArrayList<Point_3D> dsPoint2 = new ArrayList<>();
		dsPoint2.add(p_3d);

		resetPoint(p_3d);
		System.out.println(p_3d);
	}

	public static void resetPoint(Object p) {
		if (p instanceof Point2D) {
			((Point2D) p).setX(0);
			((Point2D) p).setY(0);
		}
		if (p instanceof Point3D) {
			((Point3D) p).setX(0);
			((Point3D) p).setY(0);
			((Point3D) p).setZ(0);
		}
		if (p instanceof Point_3D) {
			((Point_3D) p).setX(0);
			((Point_3D) p).setY(0);
			((Point_3D) p).setZ(0);
		}

	}
}
