package com.udeni.e_commerce_system_development_task.data.local.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.udeni.e_commerce_system_development_task.data.local.dao.DatabaseDao;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.Order;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.OrderItem;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.view.OrderWithItems;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.Customer;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.Item;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class DatabaseRepository {
    private final DatabaseDao databaseDao;
    private final Executor executor;
    private LiveData<List<com.udeni.e_commerce_system_development_task.data.local.model.Order>> orderList;
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

    public LiveData<Boolean> isDataSaved() {
        return isDataSaved;
    }

    public LiveData<List<OrderWithItems>> getAllOrdersWithItems() {
        return databaseDao.getAllOrdersWithItems();
    }
}