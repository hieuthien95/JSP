/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.CategoryDAO;
import dao.ProductDAO;
import java.util.ArrayList;
import model.Category;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author hieut
 */
public class ProductService {
    
    @Autowired
    ProductDAO productDAO;

    public ArrayList<Product> getAllProduct() {
        return productDAO.getAllProduct();
    }
}
