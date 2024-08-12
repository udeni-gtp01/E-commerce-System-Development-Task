package com.udeni.e_commerce_system_development_task.data.remote.service;

import com.udeni.e_commerce_system_development_task.data.remote.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OrderApiService {
    @GET("getOrders")
    Call<ApiResponse> getOrders();
}
