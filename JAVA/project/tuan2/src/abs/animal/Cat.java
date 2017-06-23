package abs.animal;

public class Cat extends Animal {
	private double speed;

	public double runningSpeed() {
		return speed;
	}

	public void getSpeed(double speed) {
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
		System.out.println("My name a cat");
	}

	@Override
	public String getVoice() {
		return "Meo Meo";
	}

	@Override
	public int getLegs() {
		return 4;
	}

	public Cat() {
		super();
	}

	public Cat(String color, int speed) {
		super(color);
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Cat [speed=" + speed + "]";
	}

	@Override
	public double movingSpeed() {
		return runningSpeed();
	}

	@Override
	public int compareTo(Animal o) {
		return (int) (this.movingSpeed()-o.movingSpeed());
	}
}
