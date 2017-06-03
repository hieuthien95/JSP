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
public class BillDetail {

    private long billDetailID;
    private long billID;
    private long productID;
    private double price;
    private int quantity;

    public BillDetail() {
    }

    public BillDetail(long billDetailID, long billID, long productID, double price, int quantity) {
        this.billDetailID = billDetailID;
        this.billID = billID;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    public long getBillDetailID() {
        return billDetailID;
    }

    public long getBillID() {
        return billID;
    }

    public long getProductID() {
        return productID;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setBillDetailID(long billDetailID) {
        this.billDetailID = billDetailID;
    }

    public void setBillID(long billID) {
        this.billID = billID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "BillDetail{" + "billDetailID=" + billDetailID + ", billID=" + billID + ", productID=" + productID + ", price=" + price + ", quantity=" + quantity + '}';
    }

}
