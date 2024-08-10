package com.udeni.e_commerce_system_development_task.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.udeni.e_commerce_system_development_task.data.remote.ApiCustomer;
import com.udeni.e_commerce_system_development_task.data.remote.ApiItem;
import com.udeni.e_commerce_system_development_task.data.remote.ApiOrder;
import com.udeni.e_commerce_system_development_task.data.remote.ApiOrderItem;
import com.udeni.e_commerce_system_development_task.data.remote.ApiResponse;
import com.udeni.e_commerce_system_development_task.data.remote.repository.OrderApiRepository;
import com.udeni.e_commerce_system_development_task.database.entity.Item;
import com.udeni.e_commerce_system_development_task.database.entity.Order;
import com.udeni.e_commerce_system_development_task.database.entity.OrderItem;
import com.udeni.e_commerce_system_development_task.database.repository.DatabaseRepository;
import com.udeni.e_commerce_system_development_task.database.entity.Customer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class OrderListViewmodel extends ViewModel {
    private final OrderApiRepository orderApiRepository;
    private final DatabaseRepository databaseRepository;

    @Inject
    OrderListViewmodel(OrderApiRepository orderApiRepository, DatabaseRepository databaseRepository) {
        this.orderApiRepository = orderApiRepository;
        this.databaseRepository = databaseRepository;
    }
    // Create a LiveData with a String
    private LiveData<List<Order>> orderList;

    public LiveData<List<Order>> getOrderList() {
        if (orderList == null) {
            orderList = new MutableLiveData<List<Order>>();
        }
        return orderList;
    }

//    private LiveData<List<Order>> dbOrderList;
//
//    public LiveData<List<Order>> getDbOrderList() {
//        if (dbOrderList == null) {
//            dbOrderList = new MutableLiveData<List<Order>>();
//        }
//        return dbOrderList;
//    }

    public void getOrders() {

        Call<ApiResponse> apiCall = orderApiRepository.getOrdersFromApi();
//            final Response<ApiResponse>[] apiResponse = new Response[]{null};
        apiCall.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    ApiResponse apiResponse = response.body();
//                    getApiResponse().setValue(apiResponse);
                    Log.d("******", "success");
                    List<Customer> customers = getCustomers(apiResponse);
                    List<Item> items =getItems(apiResponse);
                    List<Order> orders=getOrders(apiResponse);
                    List<OrderItem> orderItems=getOrderItems(apiResponse);
                    databaseRepository.saveToDatabase(customers,items,orders,orderItems);
//                    databaseRepository.saveCustomersInDatabase(customers);
//                    databaseRepository.saveItemsInDatabase(items);
//                    databaseRepository.saveOrdersInDatabase(orders);
//                    databaseRepository.saveOrderItemsInDatabase(orderItems);
//                    searchOrderList();
                    orderList=databaseRepository.getOrderList();
//                    getOrderList().setValue(databaseRepository.getOrderList());

//                    List<com.udeni.e_commerce_system_development_task.model.Order> orderList=new ArrayList<>();
//                    databaseRepository.searchOrderList();
//                    dbOrderList=databaseRepository.getOrderList();
//                    databaseRepository.getOrderList().observeForever(newOrderList -> {
//                        if (newOrderList != null) {
//                            for (Order searchedOrder : newOrderList) {
//                                com.udeni.e_commerce_system_development_task.model.Order modelOrder=new com.udeni.e_commerce_system_development_task.model.Order();
//                                modelOrder.setOrderNumber(String.valueOf(searchedOrder.getReceiptNumber()));
//                                orderList.add(modelOrder);
//                            }
//                            // Update your MutableLiveData (orderList) here
//                            getOrderList().setValue(orderList);
//                            Log.d("******", "ordersize" + orderList.size());
//
//                        }
//                    });

//                    LiveData<List<Order>> searchedOrders= databaseRepository.getOrderList();
//                    if(searchedOrders.getValue()!=null){
//                        for(Order searchedOrder:searchedOrders.getValue()){
//                            com.udeni.e_commerce_system_development_task.model.Order modelOrder=new com.udeni.e_commerce_system_development_task.model.Order();
//                            modelOrder.setOrderNumber(String.valueOf(searchedOrder.getReceiptNumber()));
//                            orderList.add(modelOrder);
//                        }
//
//                        getOrderList().setValue(orderList);
//                    }

//                    databaseRepository.getAllCustomers();
//                return response.body();

                } else {
                    Log.d("******", "unsuccessful");
//                    getOrderList().setValue(new ArrayList<>());
                    // Handle error cases here, e.g., log the error, return a default value, or throw an exception
//                    Log.e("OrderApiRepository", "Error fetching orders: " + apiResponse[0] + " " + apiResponse[0]);
//                        return new ApiResponse(); // Or handle the error appropriately
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable throwable) {
                Log.e("OrderApiRepository", "Exception fetching orders");
                Log.d("******", "failure");
//                getOrderList().setValue(new ArrayList<>());
            }
        });
//        databaseRepository.searchOrderList();
//        dbOrderList=databaseRepository.getOrderList();

    }
    public void searchOrderList(){
        databaseRepository.searchOrderList();
    }

    private List<Item> getItems(ApiResponse apiResponse) {
        List<ApiItem> apiItems = apiResponse.getItems();
        List<Item> items = new ArrayList<>();
        for (ApiItem apiItem : apiItems) {
            Item item = new Item( apiItem.getItemCode(), apiItem.getName(), apiItem.getItemPrice());
            items.add(item);
        }
        return items;
    }

    private List<Order> getOrders(ApiResponse apiResponse) {
        List<ApiOrder> apiOrders = apiResponse.getOrders();
        List<Order> orders = new ArrayList<>();
        for (ApiOrder apiOrder : apiOrders) {
            Order order= new Order(apiOrder.getReceiptNumber(),apiOrder.getCustomerId(),apiOrder.getDateTime());
            orders.add(order);
        }
        return orders;
    }

    private List<OrderItem> getOrderItems(ApiResponse apiResponse) {
        List<ApiOrder> apiOrders = apiResponse.getOrders();
        List<OrderItem> orderItems = new ArrayList<>();
        for (ApiOrder apiOrder : apiOrders) {
            for(ApiOrderItem apiOrderItem:apiOrder.getOrderItems()){
                OrderItem orderItem=new OrderItem(apiOrder.getReceiptNumber(),apiOrderItem.getItemCode(),apiOrderItem.getQty(),apiOrderItem.getItemPrice());
                orderItems.add(orderItem);
            }
        }
        return orderItems;
    }

    private static @NonNull List<Customer> getCustomers(ApiResponse apiResponse) {
        List<ApiCustomer> apiCustomers = apiResponse.getCustomers();
        List<Customer> customers = new ArrayList<>();

        for (ApiCustomer apiCustomer : apiCustomers) {
            Customer customer = new Customer(
                    apiCustomer.getCustomerId(),
                    apiCustomer.getName(),
                    apiCustomer.getContact()
            );
            customers.add(customer);
        }
        return customers;
    }
}
