package com.udeni.e_commerce_system_development_task.model;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderItem implements Parcelable {
    private String itemCode;
    private double qty;
    private double itemPrice;

    public OrderItem() {}

    public OrderItem(String itemCode, double qty, double itemPrice) {
        this.itemCode = itemCode;
        this.qty = qty;
        this.itemPrice = itemPrice;
    }

    protected OrderItem(Parcel in) {
        itemCode = in.readString();
        qty = in.readDouble();
        itemPrice = in.readDouble();
    }

    public static final Creator<OrderItem> CREATOR = new Creator<OrderItem>() {
        @Override
        public OrderItem createFromParcel(Parcel in) {
            return new OrderItem(in);
        }

        @Override
        public OrderItem[] newArray(int size) {
            return new OrderItem[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemCode);
        dest.writeDouble(qty);
        dest.writeDouble(itemPrice);
    }
}
