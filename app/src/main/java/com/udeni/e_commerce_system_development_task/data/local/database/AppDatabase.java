package com.udeni.e_commerce_system_development_task.data.local.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.udeni.e_commerce_system_development_task.data.local.dao.DatabaseDao;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.Customer;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.Item;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.Order;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.OrderItem;

@Database(entities = {Customer.class, Item.class, Order.class, OrderItem.class}, version = 8)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DatabaseDao databaseDao();
}