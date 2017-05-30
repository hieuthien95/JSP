package interfaces.motor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Yamaha {

	public static void main(String[] args) {
		ArrayList<Motor> dsXe = new ArrayList<Motor>();

		boolean brk = true;

		do {
			System.out.println("1. Input\n2. Display\n3. Sort\n4. Search\n5. Thoat");
			Scanner sc = new Scanner(System.in);
			int chucNang = sc.nextInt();

			switch (chucNang) {
			case 1:
				dsXe.add(new Jupiter());
				dsXe.add(new Jupiter());
				dsXe.add(new Jupiter());
				dsXe.add(new Serius());
				dsXe.add(new Serius());
				dsXe.add(new Serius());
				break;

			case 2:
				System.out.println(dsXe);
				Collections.sort(dsXe, new Comparator<Motor>() {
					@Override
					public int compare(Motor m1, Motor m2) {
						return m1.getWarranty() - m2.getWarranty();
					}
				});
				System.out.println(dsXe);
				break;

			case 3:
				for (Motor i : dsXe)
					if (i instanceof Serius)
						System.out.println(i);
				break;

			case 4:
				System.out.println(dsXe);
				break;
			case 5:
				ArrayList<Motor> dsTmp = new ArrayList<>();
				for(Motor i:dsXe)
					if(i instanceof Serius)
						dsTmp.add(i);
				System.out.println(dsTmp);
				break;
			case 6:

				break;
			}
		} while (brk);

	}
}
