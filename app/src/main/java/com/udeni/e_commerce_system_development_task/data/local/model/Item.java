package com.udeni.e_commerce_system_development_task.data.local.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Item implements Parcelable {

    private String itemCode;
    private String name;
    private double itemPrice;

    public Item(String itemCode, String name, double itemPrice) {
        this.itemCode = itemCode;
        this.name = name;
        this.itemPrice = itemPrice;
    }

    protected Item(Parcel in) {
        itemCode = in.readString();
        name = in.readString();
        itemPrice = in.readDouble();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(itemCode);
        dest.writeString(name);
        dest.writeDouble(itemPrice);
    }
}