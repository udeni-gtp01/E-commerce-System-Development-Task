package com.udeni.e_commerce_system_development_task.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ParcelableOrderItem implements Parcelable {
    private String itemCode;
    private double qty;
    private double itemPrice;

    // Constructor
    public ParcelableOrderItem(String itemCode, double qty, double itemPrice) {
        this.itemCode = itemCode;
        this.qty = qty;
        this.itemPrice = itemPrice;
    }

    protected ParcelableOrderItem(Parcel in) {
        itemCode = in.readString();
        qty = in.readDouble();
        itemPrice = in.readDouble();
    }

    public static final Creator<ParcelableOrderItem> CREATOR = new Creator<ParcelableOrderItem>() {
        @Override
        public ParcelableOrderItem createFromParcel(Parcel in) {
            return new ParcelableOrderItem(in);
        }

        @Override
        public ParcelableOrderItem[] newArray(int size) {
            return new ParcelableOrderItem[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(itemCode);
        dest.writeDouble(qty);
        dest.writeDouble(itemPrice);
    }
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



}
