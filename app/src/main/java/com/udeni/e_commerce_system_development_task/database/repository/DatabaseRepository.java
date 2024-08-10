package com.udeni.e_commerce_system_development_task.database.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.udeni.e_commerce_system_development_task.database.DatabaseDao;
import com.udeni.e_commerce_system_development_task.database.entity.Customer;
import com.udeni.e_commerce_system_development_task.database.entity.Item;
import com.udeni.e_commerce_system_development_task.database.entity.Order;
import com.udeni.e_commerce_system_development_task.database.entity.OrderItem;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class DatabaseRepository {
    private final DatabaseDao databaseDao;
    private final Executor executor;
    private LiveData<List<Order>> orderList;
    private MutableLiveData<Boolean> isSaved;

    @Inject
    public DatabaseRepository(DatabaseDao databaseDao, Executor executor) {
        this.databaseDao = databaseDao;
        this.executor = executor;
    }

    public void saveToDatabase(List<Customer> customers, List<Item> items, List<Order> orders, List<OrderItem> orderItems) {
        executor.execute(() -> {
            databaseDao.insertCustomers(customers);
            databaseDao.insertItems(items);
            databaseDao.insertOrders(orders);
            databaseDao.insertOrderItems(orderItems);
            isSaved.postValue(true);
        });
    }

    public void saveCustomersInDatabase(List<Customer> customers) {
        executor.execute(() -> {
            databaseDao.insertCustomers(customers);
        });
    }

    public void saveItemsInDatabase(List<Item> items) {
        executor.execute(() -> {
            databaseDao.insertItems(items);
        });
    }

    public void saveOrdersInDatabase(List<Order> orders) {
        executor.execute(() -> {
            databaseDao.insertOrders(orders);
        });
    }

    public void saveOrderItemsInDatabase(List<OrderItem> orderItems) {
        executor.execute(() -> {
            databaseDao.insertOrderItems(orderItems);
        });
    }

    public LiveData<List<Order>> getOrderList() {
//        if (orderList == null) {
//            orderList = new MutableLiveData<>();
//            // ... (Load orders from database or set an empty list) ...
//            searchOrderList();
//        }

        return orderList;
    }

    public void searchOrderList() {
        executor.execute(() -> {
//            this.orderList = databaseDao.getAllOrders();
//            Log.d("%%%%%%%%%%%",this.orderList.getValue().size()+"");
            this.orderList = databaseDao.getAllOrders();
//            List<com.udeni.e_commerce_system_development_task.model.Order> modelOrders=new ArrayList<>();
//            for(Order order:o){
//                com.udeni.e_commerce_system_development_task.model.Order modelOrder=new com.udeni.e_commerce_system_development_task.model.Order();
//                modelOrder.setOrderNumber(String.valueOf(order.getReceiptNumber()));
//                modelOrders.add(modelOrder);
//            }
//            MutableLiveData<List<com.udeni.e_commerce_system_development_task.model.Order>> liveData=new MutableLiveData<>();
//            liveData.postValue(modelOrders);
//            this.orderList=liveData;
        });
    }
}
