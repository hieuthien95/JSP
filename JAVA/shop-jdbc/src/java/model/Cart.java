/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
        boolean bln = cartItems.containsKey(key);
        if (bln) {
            int quantity_old = item.getQuantity();
            item.setQuantity(quantity_old + 1);
            cartItems.put(item.getProduct().getProductID(), item);
        } else {
            cartItems.put(item.getProduct().getProductID(), item);
        }
    }

    // phương thức xóa sản phẩm ở giỏ hàng
    public void removeToCart(Long product) {
        boolean bln = cartItems.containsKey(product);
        if (bln) {
            cartItems.remove(product);
        }
    }

    // phương thức tính tổng sản phẩm có trong giỏ hàng
    public int countItem() {
        int count = cartItems.size();
        return count;
    }

    //phương thức tính tổng tiền
    public double total() {
        int count = 0;
        for (Map.Entry<Long, Item> list : cartItems.entrySet()) {
            count += list.getValue().getProduct().getProductPrice() * list.getValue().getQuantity();
        }
        return count;
    }
}
