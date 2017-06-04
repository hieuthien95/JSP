package hibernate.model;

public class Item {

	private SanPham product;
	private int quantity;

	public SanPham getProduct() {
		return product;
	}

	public void setProduct(SanPham product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Item() {
		super();
	}

	public Item(SanPham product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [product=" + product + ", quantity=" + quantity + "]";
	}

}