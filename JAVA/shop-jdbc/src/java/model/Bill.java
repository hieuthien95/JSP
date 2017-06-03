/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author hieut
 */
public class Bill {
    private long billID;
    private long userID;
    private double total;
    private String payment;
    private String address;
    private Timestamp date;

    public Bill() {
    }

    public Bill(long billID, long userID, double total, String payment, String address, Timestamp date) {
        this.billID = billID;
        this.userID = userID;
        this.total = total;
        this.payment = payment;
        this.address = address;
        this.date = date;
    }

    public long getBillID() {
        return billID;
    }

    public long getUserID() {
        return userID;
    }

    public double getTotal() {
        return total;
    }

    public String getPayment() {
        return payment;
    }

    public String getAddress() {
        return address;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setBillID(long billID) {
        this.billID = billID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bill{" + "billID=" + billID + ", userID=" + userID + ", total=" + total + ", payment=" + payment + ", address=" + address + ", date=" + date + '}';
    }
    
    
    
}
