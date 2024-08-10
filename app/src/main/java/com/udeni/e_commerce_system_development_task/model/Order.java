package com.udeni.e_commerce_system_development_task.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;
public class Order implements Parcelable {

    private String orderNumber;
    private String dateTime;
    private Customer customer;
    private List<OrderItem> orderItems;

//    public Order(String orderNumber, long dateTime, Customer customer, List<OrderItem> orderItems) {
//        this.orderNumber = orderNumber;
//        this.dateTime = dateTime;
//        this.customer = customer;
//        this.orderItems = orderItems;
//    }
public Order(){}
    protected Order(Parcel in) {
        orderNumber = in.readString();
        dateTime = in.readString();
        customer = in.readParcelable(Customer.class.getClassLoader());
        orderItems = in.createTypedArrayList(OrderItem.CREATOR);
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(orderNumber);
        dest.writeString(dateTime);
        dest.writeParcelable(customer, flags);
        dest.writeTypedList(orderItems);
    }
}
