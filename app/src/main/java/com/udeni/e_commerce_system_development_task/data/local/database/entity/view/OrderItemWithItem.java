package com.udeni.e_commerce_system_development_task.data.local.database.entity.view;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.udeni.e_commerce_system_development_task.data.local.database.entity.OrderItem;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.Item;

public class OrderItemWithItem {
    @Embedded
    public OrderItem orderItem;

    @Relation(
            parentColumn = "itemCode",
            entityColumn = "itemCode"
    )
    public Item item;
}