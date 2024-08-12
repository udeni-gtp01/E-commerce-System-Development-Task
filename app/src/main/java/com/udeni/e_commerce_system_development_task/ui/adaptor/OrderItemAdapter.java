package com.udeni.e_commerce_system_development_task.ui.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.udeni.e_commerce_system_development_task.R;
import com.udeni.e_commerce_system_development_task.data.local.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.ViewHolder> {

    private List<Order> localDataSet;
    private List<Order> orderListResult;
    private OnItemClickListener listener;

    public OrderItemAdapter(List<Order> dataSet) {
        localDataSet = new ArrayList<>(dataSet);
        orderListResult = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.order_list_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Order order = orderListResult.get(position);
        viewHolder.getTvOrderNumber().setText("Order #" + order.getOrderNumber());
        viewHolder.getTvCustomerName().setText(order.getCustomer().getName());
        viewHolder.getTvDateTime().setText(order.getDateTime());
        viewHolder.getTvTotalAmount().setText(String.valueOf(order.calculateTotalAmount()));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(order);
                }
            }
        });
    }

    // Filter logic for search
    public void filter(String text) {
        orderListResult.clear();
        if (text.isEmpty()) {
            orderListResult.addAll(localDataSet);
        } else {
            text = text.toLowerCase();
            for (Order order : localDataSet) {
                if (order.getOrderNumber().contains(text) ||
                        order.getCustomer().getName().toLowerCase().contains(text) ||
                        String.valueOf(order.getCustomer().getCustomerId()).contains(text)) {
                    orderListResult.add(order);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return orderListResult.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(Order order);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvOrderNumber;
        private final TextView tvCustomerName;
        private final TextView tvDateTime;
        private final TextView tvTotalAmount;

        public ViewHolder(View view) {
            super(view);
            tvOrderNumber = view.findViewById(R.id.tvOrderNumber);
            tvCustomerName = view.findViewById(R.id.tvCustomerName);
            tvDateTime = view.findViewById(R.id.tvDateTime);
            tvTotalAmount = view.findViewById(R.id.tvTotalAmount);
        }

        public TextView getTvOrderNumber() {
            return tvOrderNumber;
        }

        public TextView getTvCustomerName() {
            return tvCustomerName;
        }

        public TextView getTvDateTime() {
            return tvDateTime;
        }

        public TextView getTvTotalAmount() {
            return tvTotalAmount;
        }
    }
}