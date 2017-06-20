/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Map;
import model.Cart;
import model.Item;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hieut
 */
public class CartService {

    @Autowired
    Cart cart;

    public void doCart(Long key, Item item) {
        cart.doCart(key, item);
    }

    public void removeToCart(Long key) {
        cart.removeToCart(key);
    }

    public int countItem() {
        return cart.countItem();
    }

    public double total() {
        return cart.total();
    }
}
