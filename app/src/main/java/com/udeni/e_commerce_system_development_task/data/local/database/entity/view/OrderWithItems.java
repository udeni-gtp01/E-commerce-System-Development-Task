package com.udeni.e_commerce_system_development_task.data.local.database.entity.view;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.udeni.e_commerce_system_development_task.data.local.database.entity.Customer;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.Order;
import com.udeni.e_commerce_system_development_task.data.local.database.entity.OrderItem;

import java.util.List;

public class OrderWithItems {
    @Embedded
    public Order order;

    @Relation(
            parentColumn = "customerId",
            entityColumn = "customerId"
    )
    public Customer customer;

    @Relation(
            entity = OrderItem.class,
            parentColumn = "receiptNumber",
            entityColumn = "receiptNumber"
    )
    public List<OrderItemWithItem> orderItemsWithItem;
}
