package com.udeni.e_commerce_system_development_task;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.udeni.e_commerce_system_development_task.databinding.FragmentViewOrderBinding;
import com.udeni.e_commerce_system_development_task.databinding.FragmentViewOrderListBinding;
import com.udeni.e_commerce_system_development_task.model.ParcelableOrderItem;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewOrderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
//@AndroidEntryPoint
public class ViewOrderFragment extends Fragment {
    ParcelableOrderItem orderItem;
    private FragmentViewOrderBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
             orderItem= getArguments().getParcelable("orderItem");
            if (orderItem != null) {
                // Access the data from the ParcelableOrderItem
                String itemCode = orderItem.getItemCode();
                double qty = orderItem.getQty();
                double itemPrice = orderItem.getItemPrice();


            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//         binding= inflater.inflate(R.layout.fragment_view_order, container, false);
        binding=FragmentViewOrderBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setLifecycleOwner(this);
        binding.textView.setText(String.valueOf(orderItem.getItemCode()));

    }
}