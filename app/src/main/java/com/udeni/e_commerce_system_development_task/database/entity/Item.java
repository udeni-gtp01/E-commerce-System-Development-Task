package com.udeni.e_commerce_system_development_task.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Item {
    @PrimaryKey
    private int itemCode;
    private String name;
    private double itemPrice;

    public Item(int itemCode, String name, double itemPrice) {
        this.itemCode = itemCode;
        this.name = name;
        this.itemPrice = itemPrice;
    }

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
