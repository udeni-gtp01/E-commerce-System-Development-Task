package com.udeni.e_commerce_system_development_task.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.udeni.e_commerce_system_development_task.databinding.FragmentViewOrderBinding;
import com.udeni.e_commerce_system_development_task.data.local.model.Order;

public class ViewOrderFragment extends Fragment {
    Order order;
    private FragmentViewOrderBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            order = getArguments().getParcelable("order");
            if (order != null) {
                // Access the data from the ParcelableOrderItem
//                String itemCode = order.getOrderNumber();
//                double qty = order.getDateTime();
//                double itemPrice = order.getDateTime();


            }
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
        binding.textView.setText(order.getCustomer().getName());
    }
}