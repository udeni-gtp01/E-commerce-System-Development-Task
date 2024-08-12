package com.udeni.e_commerce_system_development_task.data.remote.repository;

import android.util.Log;

import com.udeni.e_commerce_system_development_task.data.remote.model.ApiResponse;
import com.udeni.e_commerce_system_development_task.data.remote.service.OrderApiService;

import javax.inject.Inject;

import retrofit2.Call;

public class OrderApiRepository {
    private final OrderApiService orderApiService;
    private final String TAG = this.getClass().getSimpleName();

    @Inject
    public OrderApiRepository(OrderApiService orderApiService) {
        this.orderApiService = orderApiService;
    }

    public Call<ApiResponse> getOrdersFromApi() {
        Call<ApiResponse> apiCall = null;
        try {
            apiCall = orderApiService.getOrders();
        } catch (Exception e) {
            // Handle exceptions, e.g., network errors
            Log.e(TAG, "Exception fetching orders", e);
            return apiCall;
        }
        return apiCall;
    }
}