package com.udeni.e_commerce_system_development_task.model;

public class OrderItem {
    private String itemCode;
    private double qty; // Or double for fractional quantities
    private double itemPrice; // Price per unit{

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

}
