package com.udeni.e_commerce_system_development_task.adaptor;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.udeni.e_commerce_system_development_task.R;
import com.udeni.e_commerce_system_development_task.data.remote.ApiOrder;
import com.udeni.e_commerce_system_development_task.model.Order;

import java.util.List;

public class OrderItemAdapter extends RecyclerView.Adapter<OrderItemAdapter.ViewHolder> {

    private List<Order> localDataSet;
    private OnItemClickListener listener;
    // Add a listener variable and setter

    /**
     * Initialize the dataset of the Adapter
     *
     * @param dataSet String[] containing the data to populate views to be used
     *                by RecyclerView
     */
    public OrderItemAdapter(List<Order> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.order_item, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("#####", viewHolder.getTextView().getText().toString());
                int position = viewHolder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Order clickedOrder = localDataSet.get(position);
                }
            }
        });
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
//        viewHolder.getTextView().setText(localDataSet.get(position).getReceiptNumber());
        Order c = localDataSet.get(position);
        if (c!=null){
            viewHolder.getTextView().setText(String.valueOf(c.getOrderItems()));
//        viewHolder.setOnItemClickListener(listener);
//        viewHolder.itemView.setOnClickListener(listener);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(c); // Assuming you want the first order item
                    }
                }
            });
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(Order order);
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView textView;
        private OnItemClickListener listener;
        private ApiOrder order;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
//            view.setOnClickListener(this);
            textView = (TextView) view.findViewById(R.id.textView1);

        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }

        public TextView getTextView() {
            return textView;
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
//                    listener.onItemClick(getOrder());
                }
            }
        }

        public ApiOrder getOrder() {
            return order;
        }

        public void setOrder(ApiOrder order) {
            this.order = order;
        }
    }

}

