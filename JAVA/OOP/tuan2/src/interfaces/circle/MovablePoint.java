package interfaces.circle;

public class MovablePoint implements IMovable {
	protected int x, y, xSpeed, ySpeed;

	public MovablePoint() {
	}

	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
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
		return "MovablePoint [x=" + x + ", y=" + y + ", xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + "]";
	}
	
	
	

}
