package kethua.animal;

public class Animal {
	private int legs;
	protected int color;
	protected String name;

	private static int count = 0;

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	public Animal() { //overloading
		super();
		System.out.println("I’m an animal");
		count++;
	}

	public Animal(String name) { //overloading
		super();
		System.out.println("I’m an animal");
		this.name = name;
		count++;
	}

	public Animal(int color, String name) { //overloading
		this(name);
		this.color = color;
	}

	public Animal(int legs, int color, String name) { //overloading
		this(color, name);
		this.legs = legs;
	}

	@Override
	public String toString() {
		return "My name is " + name;
	}

	public static int getCount() {
		return count;
	}
	
	public void getInfo(){
		System.out.println("I'm a Animal. My name is" + name); 
	}

}
