package interfaces.vehicle;

import java.util.Scanner;

public class Car extends Vehicles {
	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Car() {
		super();
	}

	public Car(String maker, String model, double price, String color) {
		super(maker, model, price);
		this.color = color;
	}
	
	@Override
	public void input() {
		Scanner sc = new Scanner(System.in);
		color = sc.nextLine();
	}
	
	@Override
	public void display() {
		System.out.println("Car [color=" + color + "]");
	}
	
	
	
}
