package com.udeni.e_commerce_system_development_task.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(primaryKeys = {"receiptNumber", "itemCode"})
public class OrderItem {
    private int receiptNumber;
    private int itemCode;
    private double qty; // Or double for fractional quantities
    private double itemPrice; // Price per unit{

    public OrderItem(int receiptNumber, int itemCode, double qty, double itemPrice) {
        this.receiptNumber = receiptNumber;
        this.itemCode = itemCode;
        this.qty = qty;
        this.itemPrice = itemPrice;
    }
//    @Relation(
//            parentColumn = "id",
//            entityColumn = "itemId",
//            associateBy = @Junction(OrderHasItems.class)
//    )
//    private List<Order> orders;
    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
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

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(int receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

//    public List<Order> getOrders() {
//        return orders;
//    }

//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }
}
