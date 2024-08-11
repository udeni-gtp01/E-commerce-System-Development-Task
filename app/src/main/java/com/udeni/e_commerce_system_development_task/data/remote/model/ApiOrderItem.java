package com.udeni.e_commerce_system_development_task.data.remote.model;

import com.google.gson.annotations.SerializedName;

public class ApiOrderItem {
    @SerializedName("itemCode")
    private int itemCode;

    @SerializedName("Qty")
    private int qty;

    @SerializedName("itemPrice")
    private double itemPrice;

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}