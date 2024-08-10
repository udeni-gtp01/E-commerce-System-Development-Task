package com.udeni.e_commerce_system_development_task.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
public class Order {

    private String orderNumber;
    private long dateTime;
    private Customer customer;
    private List<OrderItem> orderItems;

//    public Order(String orderNumber, long dateTime, Customer customer, List<OrderItem> orderItems) {
//        this.orderNumber = orderNumber;
//        this.dateTime = dateTime;
//        this.customer = customer;
//        this.orderItems = orderItems;
//    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
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
