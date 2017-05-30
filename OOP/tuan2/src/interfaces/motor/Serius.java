package interfaces.motor;

import java.util.Scanner;

public class Serius extends Motor {
	private int warranty;

	@Override
	public void inputInfor() {
		Scanner sc = new Scanner(System.in);
		warranty = sc.nextInt();
	}

	@Override
	public void displayInfor() {
		System.out.println(warranty);
	}

	@Override
	public void changeInfor() {
		Scanner sc = new Scanner(System.in);
		warranty = sc.nextInt();
	}

	@Override
	public int getWarranty() {
		return warranty;
	}

	@Override
	public String toString() {
		return "Serius [warranty=" + warranty + "]";
	}
	
	
}
