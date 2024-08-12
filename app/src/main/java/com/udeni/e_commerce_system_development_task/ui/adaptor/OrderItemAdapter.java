package com.udeni.e_commerce_system_development_task.ui.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.udeni.e_commerce_system_development_task.R;
import com.udeni.e_commerce_system_development_task.data.local.model.OrderItem;

import java.util.List;

public class OrderItemAdapter extends BaseAdapter {

    private Context context;
    private List<OrderItem> orderItems;
    private LayoutInflater inflater;

    public OrderItemAdapter(Context context, List<OrderItem> orderItems) {
        this.context = context;
        this.orderItems = orderItems;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return orderItems.size();
    }

    @Override
    public Object getItem(int position) {
        return orderItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.order_item, parent, false);
            holder = new ViewHolder();
            holder.itemName = convertView.findViewById(R.id.tv_item_name_qty);
            holder.itemPrice = convertView.findViewById(R.id.tv_item_price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Get the current order item
        OrderItem orderItem = orderItems.get(position);

        // Set the data to the views
        holder.itemName.setText(orderItem.getItemCode().getName() + " X " + orderItem.getQty());
        holder.itemPrice.setText(String.valueOf(orderItem.getItemPrice()));
        return convertView;
    }

    private static class ViewHolder {
        TextView itemName;
        TextView itemPrice;
    }
}