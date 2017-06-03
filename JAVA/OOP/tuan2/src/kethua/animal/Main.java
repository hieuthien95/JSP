package kethua.animal;

public class Main {

	public static void main(String []args){
		new Animal(0, 0, "Animal 1");
		Dog d = new Dog(1, "Lu");
		new Bird(3, "Chiper");
		new Fish(3, "Fisher");
		
		System.out.println(d);
	}
}
