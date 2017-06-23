package interfaces.vehicle;

public class Vehicles implements IVehicle {
	private String maker;
	private String model;
	private double price;

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Vehicles(String maker, String model, double price) {
		super();
		this.maker = maker;
		this.model = model;
		this.price = price;
	}

	public Vehicles() {
		super();
	}

	@Override
	public void input() {
	}

	@Override
	public void display() {
		System.out.println("Vehicles [maker=" + maker + ", model=" + model + ", price="
				+ price + "]");
	}
	
	

}
