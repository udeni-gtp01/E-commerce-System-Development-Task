package com.udeni.e_commerce_system_development_task.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Customer {
    @PrimaryKey
    private int customerId;
    private String name;
    private String contact;

    public Customer(int customerId, String name, String contact) {
        this.customerId = customerId;
        this.name = name;
        this.contact = contact;
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
