package com.udeni.e_commerce_system_development_task.data.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    @SerializedName("customers")
    private List<ApiCustomer> customers;

    @SerializedName("items")
    private List<ApiItem> items;

    @SerializedName("orders")
    private List<ApiOrder> orders;

    public List<ApiCustomer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<ApiCustomer> customers) {
        this.customers = customers;
    }

    public List<ApiItem> getItems() {
        return items;
    }

    public void setItems(List<ApiItem> items) {
        this.items = items;
    }

    public List<ApiOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<ApiOrder> orders) {
        this.orders = orders;
    }
}

