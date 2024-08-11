package com.udeni.e_commerce_system_development_task.data.remote.model;

import com.google.gson.annotations.SerializedName;

public class ApiItem {
    @SerializedName("itemCode")
    private int itemCode;

    @SerializedName("name")
    private String name;

    @SerializedName("itemPrice")
    private double itemPrice;

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}