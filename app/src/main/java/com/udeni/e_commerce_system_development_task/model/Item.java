package com.udeni.e_commerce_system_development_task.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class Item {

    private String itemCode;
    private String name;
    private double itemPrice;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
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
