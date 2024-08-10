package com.udeni.e_commerce_system_development_task.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.udeni.e_commerce_system_development_task.database.entity.Customer;
import com.udeni.e_commerce_system_development_task.database.entity.Item;
import com.udeni.e_commerce_system_development_task.database.entity.Order;
import com.udeni.e_commerce_system_development_task.database.entity.OrderItem;

@Database(entities = {Customer.class, Item.class, Order.class, OrderItem.class} ,version = 7)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DatabaseDao databaseDao();
//    public abstract ItemDao itemDao();
//    public abstract OrderDao orderDao();
//    public abstract OrderItemDao orderItemDao();
}
