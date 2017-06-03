package interfaces.vehicle;

import java.util.Scanner;

public class Truck extends Vehicles {
	private int truckload;

	public int getTruckload() {
		return truckload;
	}

	public void setTruckload(int truckload) {
		this.truckload = truckload;
	}

	public Truck() {
		super();
	}

	public Truck(String maker, String model, double price, int itruckload) {
		super(maker, model, price);
		truckload = itruckload;
	}
	
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		truckload = sc.nextInt();
	}
	
	@Override
	public void display() {
		System.out.println("Car [truckload=" + truckload + "]");
	}

}
