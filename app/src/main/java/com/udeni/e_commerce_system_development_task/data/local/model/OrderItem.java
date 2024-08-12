package com.udeni.e_commerce_system_development_task.data.local.model;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderItem implements Parcelable {
    private Item item;
    private double qty;
    private double itemPrice;

    public OrderItem() {
    }

    public OrderItem(Item item, double qty, double itemPrice) {
        this.item = item;
        this.qty = qty;
        this.itemPrice = itemPrice;
    }

    protected OrderItem(Parcel in) {
        item = in.readParcelable(Item.class.getClassLoader());
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

    public Item getItemCode() {
        return item;
    }

    public void setItemCode(Item item) {
        this.item = item;
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
        dest.writeParcelable(item, flags);
        dest.writeDouble(qty);
        dest.writeDouble(itemPrice);
    }
}