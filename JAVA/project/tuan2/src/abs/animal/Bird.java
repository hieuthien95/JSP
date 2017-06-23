package abs.animal;

public class Bird extends Animal {
	private double speed;

	public double flyingSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public String getColor() {
		return super.getColor();
	}

	public void setColor(String color) {
		super.setColor(color);
	}

	@Override
	public void getName() {
		System.out.println("My name a dog");
	}

	@Override
	public String getVoice() {
		return "Chip Chip";
	}

	@Override
	public int getLegs() {
		return 2;
	}

	public Bird() {
		super();
	}

	public Bird(String color, int speed) {
		super(color);
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Bird [speed=" + speed + "]";
	}

	@Override
	public double movingSpeed() {
		return flyingSpeed();
	}

	@Override
	public int compareTo(Animal o) {
		return (int) (this.movingSpeed()-o.movingSpeed());
	}

}
