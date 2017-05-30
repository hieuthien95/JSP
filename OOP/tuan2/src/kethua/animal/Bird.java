package kethua.animal;

public class Bird extends Animal {
	private static int birdcount = 0;

	public Bird() { //overloading
		System.out.println("I'm bird");
		birdcount++;
	}

	public Bird(int color, String name) { //overloading
		super(2, color, name);
		System.out.println("I'm bird");
		birdcount++;
	}

	public static int getCount() {
		return birdcount;
	}

	public static int getCount(boolean b) {
		if (b == true)
			return birdcount;
		else
			return Animal.getCount();
	}

	@Override
	public void getInfo() {
		System.out.println("I'm a bird. My name is" + name);
	}

	public String getVoice() {
		return "Chip chip";
	}

}
