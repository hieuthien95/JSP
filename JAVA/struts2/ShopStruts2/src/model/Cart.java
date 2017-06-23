package model;

import java.util.HashMap;
import java.util.Map;

import dao.SanPhamDAO;

public class Cart {

	private HashMap<Long, Item> dsItem;
	
	public Cart() {
		super();
		this.dsItem = new HashMap<>();
	}

	public Cart(HashMap<Long, Item> dsItem) {
		super();
		this.dsItem = dsItem;
	}

	public HashMap<Long, Item> getDsItem() {
		return dsItem;
	}

	public void setDsItem(HashMap<Long, Item> dsItem) {
		this.dsItem = dsItem;
	}

	public void insertToCart(Long key, Item item) {
		boolean tontai = dsItem.containsKey(key);
		if (tontai) {
			int qty_old = item.getQty();
			item.setQty(qty_old + 1);
			dsItem.put((long) item.getProduct().getId(), item);
		} else {
			dsItem.put((long) item.getProduct().getId(), item);
		}
	}

	public void subInCart(Long key, Item item) {
		boolean tontai = dsItem.containsKey(key);
		if (tontai) {
			int qty_old = item.getQty();
			if(qty_old==1) {
				removeToCart((long)item.getProduct().getId());
			} else {
				item.setQty(qty_old - 1);
				dsItem.put((long) item.getProduct().getId(), item);
			}
		}
	}

	public void removeToCart(Long productid) {
		boolean tontai = dsItem.containsKey(productid);
		if (tontai)
			dsItem.remove(productid);
	}

	public int countItem() {
		int count = dsItem.size();
		return count;
	}

	public double total() {
		double count = 0;
		for (Map.Entry<Long, Item> list : dsItem.entrySet()) {
			count += list.getValue().getProduct().getGia() * list.getValue().getQty();
		}
		return count;
	}

	@Override
	public String toString() {
		return "Cart [dsItem=" + dsItem + "]";
	}
	
	public static void main(String[] args) {
		SanPham sp1 = new SanPhamDAO().getSanPhamById(98);
		SanPham sp2 = new SanPhamDAO().getSanPhamById(68);
		SanPham sp3 = new SanPhamDAO().getSanPhamById(71);
		SanPham sp4 = new SanPhamDAO().getSanPhamById(70);
		
		Cart cart = new Cart();
		cart.insertToCart((long)sp1.getId(), new Item(sp1, 1));
		cart.insertToCart((long)sp2.getId(), new Item(sp2, 1));
		cart.insertToCart((long)sp3.getId(), new Item(sp3, 1));
		cart.insertToCart((long)sp4.getId(), new Item(sp4, 1));
		
		cart.removeToCart((long)98);
		System.out.println(cart.getDsItem());
		
//		System.out.println(cart.getDsItem().get((long)sp1.getId()).getQty());
	}

}
