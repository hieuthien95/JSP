/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hieut
 */
public class Product {
    private long productID;
    private long categoryID;
    private String productName;
    private String productImage;
    private double productPrice;
    private String productDesciption;
    
    public Product() {
    }

    public Product(long productID, long categoryID, String productName, String productImage, double productPrice, String productDesciption) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productDesciption = productDesciption;
    }

    public long getProductID() {
        return productID;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDesciption;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductDesciption(String productDesciption) {
        this.productDesciption = productDesciption;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", categoryID=" + categoryID + ", productName=" + productName + ", productImage=" + productImage + ", productPrice=" + productPrice + ", productDesciption=" + productDesciption + '}';
    }

}
