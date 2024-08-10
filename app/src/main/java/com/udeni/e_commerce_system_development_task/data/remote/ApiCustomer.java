package com.udeni.e_commerce_system_development_task.data.remote;

import com.google.gson.annotations.SerializedName;

public class ApiCustomer {
    @SerializedName("customerId")
    private int customerId;
    @SerializedName("name")
    private String name;
    @SerializedName("contact")
    private String contact;
//    private int customerId;
//    private String name;
//    private String contact;
//
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

    // Constructors, getters, and setters
}
