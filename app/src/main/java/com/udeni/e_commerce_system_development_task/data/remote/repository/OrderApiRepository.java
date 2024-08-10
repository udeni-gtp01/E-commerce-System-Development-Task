package com.udeni.e_commerce_system_development_task.data.remote.repository;

import com.udeni.e_commerce_system_development_task.data.remote.ApiResponse;
import com.udeni.e_commerce_system_development_task.data.remote.service.OrderApiService;

import javax.inject.Inject;

import retrofit2.Call;

public class OrderApiRepository {
    private final OrderApiService orderApiService;

    @Inject
    public OrderApiRepository(OrderApiService orderApiService) {
        this.orderApiService = orderApiService;
    }

    public Call<ApiResponse> getOrdersFromApi() {
//        try {
        Call<ApiResponse> apiCall = orderApiService.getOrders();
//            final Response<ApiResponse>[] apiResponse = new Response[]{null};

//
//        } catch (Exception e) {
//            // Handle exceptions, e.g., network errors
//            Log.e("OrderApiRepository", "Exception fetching orders", e);
////            return new ApiResponse(); // Or handle the exception appropriately
//            return null;
//        }
        return apiCall;
    }
}
