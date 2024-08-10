package com.udeni.e_commerce_system_development_task.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.udeni.e_commerce_system_development_task.constant.AppConstant;
import com.udeni.e_commerce_system_development_task.database.entity.Customer;
import com.udeni.e_commerce_system_development_task.database.entity.Item;
import com.udeni.e_commerce_system_development_task.database.entity.Order;
import com.udeni.e_commerce_system_development_task.database.entity.OrderItem;

import java.util.List;


@Dao
public interface DatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCustomers(List<Customer> customers);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItems(List<Item> items);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrders(List<Order> orders);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrderItems(List<OrderItem> orderItems);

    @Query("Select * from " + AppConstant.TABLE_ORDER)
    LiveData<List<Order>> getAllOrders();

    @Query("Select * from " + AppConstant.TABLE_CUSTOMER + " WHERE customerId = :customerId")
    Customer getCustomerById(int customerId);

}
