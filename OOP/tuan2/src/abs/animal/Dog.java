package abs.animal;

public class Dog extends Animal {
	private double speed;

	public double runningSpeed() {
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
		return "Gau Gau";
	}

	@Override
	public int getLegs() {
		return 4;
	}

	public Dog() {
		super();
	}

	public Dog(String color, int speed) {
		super(color);
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Dog [speed=" + speed + "]";
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
