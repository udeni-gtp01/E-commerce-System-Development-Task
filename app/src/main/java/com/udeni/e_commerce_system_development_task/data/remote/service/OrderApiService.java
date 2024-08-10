package com.udeni.e_commerce_system_development_task.data.remote.service;

import com.udeni.e_commerce_system_development_task.data.remote.ApiResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface OrderApiService {
    @GET("getOrders")
    Call<ApiResponse> getOrders();
//    @GET("getOrders")
//    Response<ApiResponse> getOrders();
}
