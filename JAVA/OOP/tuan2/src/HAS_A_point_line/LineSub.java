package HAS_A_point_line;

public class LineSub {
	private Point end;

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public LineSub() {
		super();
	}

	public LineSub(Point end) {
		super();
		this.end = end;
	}

	@Override
	public String toString() {
		return "LineSub [end=" + end + "]";
	}

}
