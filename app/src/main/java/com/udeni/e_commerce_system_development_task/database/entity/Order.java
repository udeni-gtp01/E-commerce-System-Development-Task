package com.udeni.e_commerce_system_development_task.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "CustomerOrder")
public class Order {
    @PrimaryKey
    private int receiptNumber;
    private int customerId;
    private String dateTime;

    public Order(int receiptNumber, int customerId, String dateTime) {
        this.receiptNumber = receiptNumber;
        this.customerId = customerId;
        this.dateTime = dateTime;
    }


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
}
