package interfaces.vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Vehicles> dsXe = new ArrayList<Vehicles>();

		boolean brk = true;

		do {
			System.out.println("1. Input\n2. Display\n3. Sort by price \n"
					+ "4. Search by model. \n5. Exit");
			Scanner sc = new Scanner(System.in);
			int chucNang = sc.nextInt();

			switch (chucNang) {
			case 1:
				dsXe.add(new Car());
				dsXe.add(new Car());
				dsXe.add(new Car());
				dsXe.add(new Truck());
				dsXe.add(new Truck());
				dsXe.add(new Truck());
				break;

			case 2:
				System.out.println(dsXe);
				break;

			case 3:
				System.out.println(dsXe);
				Collections.sort(dsXe, new Comparator<Vehicles>() {
					@Override
					public int compare(Vehicles v1, Vehicles v2) {
						return (int) (v1.getPrice() - v2.getPrice());
					}
				});
				break;

			case 4:
				System.out.println("Nhap ma xe: ");
				String imodel = sc.nextLine();
				for (Vehicles i : dsXe)
					if (i.getModel().equals(imodel))
						System.out.println(i);
				break;
			case 5:

				break;
			}
		}while(brk);
		
	}
}
