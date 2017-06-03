package interfaces.motor;

import java.util.Scanner;

public class Jupiter extends Motor {
	private int warranty;

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

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
	public String toString() {
		return "Jupiter [warranty=" + warranty + "]";
	}

}
