package com.udeni.e_commerce_system_development_task.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.udeni.e_commerce_system_development_task.R;
import com.udeni.e_commerce_system_development_task.data.local.model.Order;
import com.udeni.e_commerce_system_development_task.databinding.FragmentViewOrderBinding;
import com.udeni.e_commerce_system_development_task.ui.adaptor.OrderItemAdapter;

public class ViewOrderFragment extends Fragment {
    private Order order;
    private FragmentViewOrderBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            order = getArguments().getParcelable("order");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentViewOrderBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setLifecycleOwner(this);
        String totalAmount = String.valueOf(order.calculateTotalAmount());
        binding.tvTotalAmount.setText(totalAmount);
        binding.tvTotalPrice.setText(totalAmount);
        binding.tvOrderId.setText(String.format(getString(R.string.order_number), order.getOrderNumber()));
        binding.tvCustomerName.setText(String.format(getString(R.string.customer_name), order.getCustomer().getName()));
        binding.tvOrderDatetime.setText(String.format(getString(R.string.date_time), order.getDateTime()));
        ListView listView = view.findViewById(R.id.lv_items);
        OrderItemAdapter adapter = new OrderItemAdapter(getContext(), order.getOrderItems());
        listView.setDivider(null);
        listView.setAdapter(adapter);
    }
}