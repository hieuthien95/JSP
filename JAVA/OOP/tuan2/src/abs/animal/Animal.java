package abs.animal;

public abstract class Animal implements Comparable<Animal>{
	private String color;
	private int count = 0;

	public abstract String getVoice();

	public abstract int getLegs();

	public abstract double movingSpeed();

	public void getName() {
		System.out.println("My name is animal");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCount() {
		return count;
	}

	public Animal() {
		super();
		count++;
	}

	public Animal(String color) {
		super();
		this.color = color;
		count++;
		System.out.println("My name is animal");
	}

	@Override
	public String toString() {
		return "Animal [color=" + color + "]";
	}

}
