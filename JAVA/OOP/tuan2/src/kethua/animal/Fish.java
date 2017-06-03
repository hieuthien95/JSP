package kethua.animal;

public class Fish extends Animal {
	private static int fishcount = 0;

	public Fish() { //overloading
		System.out.println("I'm fish");
		fishcount++;
	}

	public Fish(int color, String name) { //overloading
		super(4, color, name);
		System.out.println("I'm fish");
		fishcount++;
	}

	public static int getCount() {
		return fishcount;
	}

	public static int getCount(boolean b) {
		if (b == true)
			return fishcount;
		else
			return Animal.getCount();
	}

	@Override
	public void getInfo() {
		System.out.println("I'm a Fish. My name is" + name);
	}

	public String getVoice() {
		return ".oO";
	}

}
