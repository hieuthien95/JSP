package HAS_A_point_line;

import java.util.ArrayList;

public class Line extends Point {
	private Point begin;
	private Point end;

	public Point getBegin() {
		return begin;
	}

	public void setBegin(Point begin) {
		this.begin = begin;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public Line(int x, int y, Point begin, Point end) {
		super(x, y);
		this.begin = begin;
		this.end = end;
	}

	public Line() {
		super();
	}

	public Line(int x, int y) {
		super(x, y);
	}

	@Override
	public String toString() {
		return "[Line [begin=(" + begin.getX() + ", " + begin.getY() + "), end=(" + end.getX() + ", " + end.getY()
				+ ")]";
	}
	
	public ArrayList<Integer> getXY(){
		ArrayList<Integer> i = new ArrayList<>();
		i.add(begin.getX());
		i.add(begin.getY());
		return i;
	}

}
