package com.udeni.e_commerce_system_development_task.data.local.database.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "CustomerOrder")
public class Order {
    @PrimaryKey
    private int receiptNumber;
    private int customerId;
    private String dateTime;
    @Ignore
    private Customer customer;

    @Ignore
    private List<OrderItem> orderItems;

    public Order(int receiptNumber, int customerId, String dateTime) {
        this.receiptNumber = receiptNumber;
        this.customerId = customerId;
        this.dateTime = dateTime;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(int receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
