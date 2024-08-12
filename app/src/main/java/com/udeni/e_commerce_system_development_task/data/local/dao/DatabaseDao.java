package com.udeni.e_commerce_system_development_task.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.Customer;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.Item;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.Order;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.OrderItem;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.view.OrderWithItems;
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

    @Query("SELECT * FROM CustomerOrder")
    LiveData<List<OrderWithItems>> getAllOrdersWithItems();
}