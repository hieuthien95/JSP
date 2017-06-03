package interfaces.circle;

public class MovableCircle implements IMovable {
	private int radius;
	private MovableCircle center;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public MovableCircle getCenter() {
		return center;
	}

	public void setCenter(MovableCircle center) {
		this.center = center;
	}

	public MovableCircle() {
		super();
		this.center = new MovableCircle();
	}

	public MovableCircle(int radius, MovableCircle center) {
		super();
		this.center = new MovableCircle();
		this.radius = radius;
		this.center = center;
	}

	@Override
	public void moveUp() {
		
	}

	@Override
	public void moveDown() {
		
	}

	@Override
	public void moveLeft() {
		
	}

	@Override
	public void moveRight() {
		
	}

	@Override
	public String toString() {
		return "MovableCircle [radius=" + radius + ", center=" + center + "]";
	}

	
}
