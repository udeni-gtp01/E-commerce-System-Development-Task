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
    private final MutableLiveData<Boolean> isDataSaved = new MutableLiveData<>(false);


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
            isDataSaved.postValue(true);
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
    public LiveData<Boolean> isDataSaved() {
        return isDataSaved;
    }
    public LiveData<List<Order>> getOrderList() {
        return databaseDao.getAllOrders();
    }

    public Customer getCustomerById(int customerId) {
        return databaseDao.getCustomerById(customerId);
    }

}
