package com.udeni.e_commerce_system_development_task.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.udeni.e_commerce_system_development_task.data.remote.model.ApiCustomer;
import com.udeni.e_commerce_system_development_task.data.remote.model.ApiItem;
import com.udeni.e_commerce_system_development_task.data.remote.model.ApiOrder;
import com.udeni.e_commerce_system_development_task.data.remote.model.ApiOrderItem;
import com.udeni.e_commerce_system_development_task.data.remote.model.ApiResponse;
import com.udeni.e_commerce_system_development_task.data.remote.repository.OrderApiRepository;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.Customer;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.Item;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.Order;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.OrderItem;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.view.OrderItemWithItem;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.view.OrderWithItems;
import com.udeni.e_commerce_system_development_task.data.local.repository.DatabaseRepository;

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
    private final String TAG = this.getClass().getSimpleName();
    private MutableLiveData<List<OrderWithItems>> orderList;

    @Inject
    OrderListViewmodel(OrderApiRepository orderApiRepository, DatabaseRepository databaseRepository) {
        this.orderApiRepository = orderApiRepository;
        this.databaseRepository = databaseRepository;
        orderList = new MutableLiveData<>();

        databaseRepository.isDataSaved().observeForever(isSaved -> {
            if (isSaved) {
                getAllOrdersWithItems();
            }
        });
    }

    public void saveDataToDatabase() {
        Call<ApiResponse> apiCall = orderApiRepository.getOrdersFromApi();
        apiCall.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    ApiResponse apiResponse = response.body();
                    List<Customer> customers = getCustomers(apiResponse);
                    List<Item> items = getItems(apiResponse);
                    List<Order> orders = getOrders(apiResponse);
                    List<OrderItem> orderItems = getOrderItems(apiResponse);
                    databaseRepository.saveToDatabase(customers, items, orders, orderItems);
                } else {
                    Log.d(TAG, "Unsuccessful response");
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable throwable) {
                Log.e(TAG, "Exception fetching orders");
            }
        });
    }

    public LiveData<List<OrderWithItems>> getAllOrdersWithItems() {
        return databaseRepository.getAllOrdersWithItems();
    }

    private List<Item> getItems(ApiResponse apiResponse) {
        List<ApiItem> apiItems = apiResponse.getItems();
        List<Item> items = new ArrayList<>();
        for (ApiItem apiItem : apiItems) {
            Item item = new Item(apiItem.getItemCode(), apiItem.getName(), apiItem.getItemPrice());
            items.add(item);
        }
        return items;
    }

    private List<Order> getOrders(ApiResponse apiResponse) {
        List<ApiOrder> apiOrders = apiResponse.getOrders();
        List<Order> orders = new ArrayList<>();
        for (ApiOrder apiOrder : apiOrders) {
            Order order = new Order(apiOrder.getReceiptNumber(), apiOrder.getCustomerId(), apiOrder.getDateTime());
            orders.add(order);
        }
        return orders;
    }

    private List<OrderItem> getOrderItems(ApiResponse apiResponse) {
        List<ApiOrder> apiOrders = apiResponse.getOrders();
        List<OrderItem> orderItems = new ArrayList<>();
        for (ApiOrder apiOrder : apiOrders) {
            for (ApiOrderItem apiOrderItem : apiOrder.getOrderItems()) {
                OrderItem orderItem = new OrderItem(apiOrder.getReceiptNumber(), apiOrderItem.getItemCode(), apiOrderItem.getQty(), apiOrderItem.getItemPrice());
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

    public List<com.udeni.e_commerce_system_development_task.data.local.model.Order> convertToModelOrders(List<OrderWithItems> ordersWithItems) {
        List<com.udeni.e_commerce_system_development_task.data.local.model.Order> modelOrders = new ArrayList<>();
        for (OrderWithItems orderWithItems : ordersWithItems) {
            com.udeni.e_commerce_system_development_task.data.local.model.Order modelOrder = new com.udeni.e_commerce_system_development_task.data.local.model.Order();
            modelOrder.setOrderNumber(String.valueOf(orderWithItems.order.getReceiptNumber()));
            modelOrder.setDateTime(orderWithItems.order.getDateTime());
            modelOrder.setCustomer(convertToModelCustomer(orderWithItems.customer));
            modelOrder.setOrderItems(convertToModelOrderItems(orderWithItems.orderItemsWithItem));
            modelOrders.add(modelOrder);
        }
        return modelOrders;
    }

    private List<com.udeni.e_commerce_system_development_task.data.local.model.OrderItem> convertToModelOrderItems(List<OrderItemWithItem> orderItems) {
        List<com.udeni.e_commerce_system_development_task.data.local.model.OrderItem> modelOrderItems = new ArrayList<>();
        for (OrderItemWithItem orderItemWithItem : orderItems) {
            com.udeni.e_commerce_system_development_task.data.local.model.OrderItem modelOrderItem = new com.udeni.e_commerce_system_development_task.data.local.model.OrderItem(convertToModelItem(orderItemWithItem.item), orderItemWithItem.orderItem.getQty(), orderItemWithItem.orderItem.getItemPrice());
            modelOrderItems.add(modelOrderItem);
        }
        return modelOrderItems;
    }

    private com.udeni.e_commerce_system_development_task.data.local.model.Item convertToModelItem(Item item) {
        return new com.udeni.e_commerce_system_development_task.data.local.model.Item(String.valueOf(item.getItemCode()), item.getName(), item.getItemPrice());
    }

    private com.udeni.e_commerce_system_development_task.data.local.model.Customer convertToModelCustomer(Customer customer) {
        return new com.udeni.e_commerce_system_development_task.data.local.model.Customer(customer.getCustomerId(), customer.getName(), customer.getContact());
    }
}