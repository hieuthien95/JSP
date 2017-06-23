package abs.animal;

import java.util.ArrayList;
import java.util.Collections;

public class Main{

	public static void main(String[] args) {
		ArrayList<Animal> dsA = new ArrayList<>();
		dsA.add(new Dog("white", 10));
		dsA.add(new Bird("brown", 20));
		dsA.add(new Cat("black", 5));
		dsA.add(new Dog());
		dsA.add(new Cat());
		dsA.add(new Bird());

		System.out.println(dsA);

		int tong = 0;
		for (Animal i : dsA)
			tong += i.getLegs();
		System.out.println(tong);

		for (Animal i : dsA)
			System.out.println(i.getVoice());

		// for (Animal i : dsA)
		// if (i instanceof Dog)
		// System.out.println(((Dog) i).runningSpeed());
		// else if (i instanceof Cat)
		// System.out.println(((Cat) i).runningSpeed());
		// else if (i instanceof Bird)
		// System.out.println(((Bird) i).flyingSpeed());

		// for (Animal i : dsA)
		// System.out.println(i.movingSpeed());

		for (Animal i : dsA)
			System.out.println(Main.movingSpeed(i));

//		Collections.sort(dsA, new Comparator<Animal>() {
//			@Override
//			public int compare(Animal a1, Animal a2) {
//				return (int) (a1.movingSpeed() - a2.movingSpeed());
//			}
//		});
		
		Collections.sort(dsA);

		System.out.println(dsA);
	}

	public static double movingSpeed(Animal a) {
		return a.movingSpeed();
	}
	
	
}
