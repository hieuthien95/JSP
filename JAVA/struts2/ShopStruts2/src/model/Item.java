package model;

public class Item {

	private SanPham product;
	private int qty;

	public SanPham getProduct() {
		return product;
	}

	public void setProduct(SanPham product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Item(SanPham product, int qty) {
		super();
		this.product = product;
		this.qty = qty;
	}

	public Item() {
		super();
	}

	@Override
	public String toString() {
		return "{" + product.getTen() + ", qty=" + qty + "}";
	}

}
