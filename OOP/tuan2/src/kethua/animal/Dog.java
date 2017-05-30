package kethua.animal;

public class Dog extends Animal {
	private static int dogcount = 0;

	public Dog() { //overloading
		System.out.println("I'm dog");
		dogcount++;
	}

	public Dog(int color, String name) { //overloading
		super(4, color, name);
		System.out.println("I'm dog");
		dogcount++;
	}

	public static int getCount() {
		return dogcount;
	}

	public static int getCount(boolean b) {
		if (b == true)
			return dogcount;
		else
			return Animal.getCount();
	}

	@Override
	public void getInfo() {
		System.out.println("I'm a dog. My name is" + name);
	}

	public String getVoice() {
		return "Gau gau";
	}
}
