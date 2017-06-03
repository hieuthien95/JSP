package interfaces.point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		ArrayList<Shape> dsHinh = new ArrayList<Shape>();
		dsHinh.add(new Circle("White", 1, 1, 3));
		dsHinh.add(new Circle("blue", 2, 2, 4));
		dsHinh.add(new Circle("yellow", 0, 0, 3));
		dsHinh.add(new Rectangle("dark", 2, 2, 4, 4));
		dsHinh.add(new Rectangle("red", 2, 2, 3, 3));
		dsHinh.add(new Rectangle("blue", 1, 1, 4, 4));

		double tongDT = 0;
		for (Shape i : dsHinh)
			tongDT = tongDT + i.getArea();
		System.out.println("Tong DT " + tongDT);

		Collections.sort(dsHinh, new Comparator<Shape>() {
			public int compare(Shape s1, Shape s2) {
				return (int) (s1.getArea() - s2.getArea());
			};
		});
		Collections.sort(dsHinh, new Comparator<Shape>() {
			public int compare(Shape s1, Shape s2) {
				return (int) (s1.getStartPoint().getX() - s2.getStartPoint()
						.getX());
			};
		});
		Collections.sort(dsHinh, new Comparator<Shape>() {
			public int compare(Shape s1, Shape s2) {
				if (s1.getStartPoint().getY() == s2.getStartPoint().getY())
					return (int) (s1.getStartPoint().getX() - s2
							.getStartPoint().getX());
				return (int) (s1.getStartPoint().getY() - s2.getStartPoint()
						.getY());
			};
		});
		System.out.println(dsHinh);
	}
}
