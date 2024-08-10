package com.udeni.e_commerce_system_development_task.data.remote;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiOrder {
    @SerializedName("receiptNumber")
    private int receiptNumber;
    @SerializedName("customerId")
    private int customerId;
    @SerializedName("dateTime")
    private String dateTime;
//    private int receiptNumber;
//    private int customerId;
//    private String dateTime;
    @SerializedName("orderItems")
    private List<ApiOrderItem> orderItems;
//
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

    public List<ApiOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<ApiOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    // Constructors, getters, and setters
}
