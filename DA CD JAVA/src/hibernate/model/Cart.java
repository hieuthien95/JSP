package hibernate.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	private HashMap<Long, Item> cartItems;

	public Cart() {
		cartItems = new HashMap<>();
	}

	public Cart(HashMap<Long, Item> cartItems) {
		this.cartItems = cartItems;
	}

	public HashMap<Long, Item> getCartItems() {
		return cartItems;
	}

	public void setCartItems(HashMap<Long, Item> cartItems) {
		this.cartItems = cartItems;
	}

	// phương thức thêm sản phẩm vào giỏ hàng
	public void insertToCart(Long key, Item item) {
		boolean tontai = cartItems.containsKey(key);
		if (tontai) {
			int quantity_old = item.getQuantity();
			item.setQuantity(quantity_old + 1);
			cartItems.put((long) item.getProduct().getStt(), item);
		} else {
			cartItems.put((long) item.getProduct().getStt(), item);
		}
	}

	// phương thức bớt sản phẩm ở giỏ hàng
	public void subInCart(Long key, Item item) {
		boolean tontai = cartItems.containsKey(key);
		if (tontai) {
			int quantity_old = item.getQuantity();
			if(quantity_old==1) {
				removeToCart((long)item.getProduct().getStt());
			} else {
				item.setQuantity(quantity_old - 1);
				cartItems.put((long) item.getProduct().getStt(), item);
			}
		}
	}

	// phương thức xóa sản phẩm ở giỏ hàng
	public void removeToCart(Long productid) {
		boolean tontai = cartItems.containsKey(productid);
		if (tontai)
			cartItems.remove(productid);
	}

	// phương thức tính tổng sản phẩm có trong giỏ hàng
	public int countItem() {
		int count = cartItems.size();
		return count;
	}

	// phương thức tính tổng tiền
	public double total() {
		double count = 0;
		for (Map.Entry<Long, Item> list : cartItems.entrySet()) {
			count += list.getValue().getProduct().getGia() * list.getValue().getQuantity();
		}
		return count;
	}

	@Override
	public String toString() {
		return "Cart [cartItems=" + cartItems + "]";
	}

}
