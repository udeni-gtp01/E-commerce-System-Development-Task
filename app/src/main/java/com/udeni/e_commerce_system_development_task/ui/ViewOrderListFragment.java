package com.udeni.e_commerce_system_development_task.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.udeni.e_commerce_system_development_task.R;
import com.udeni.e_commerce_system_development_task.ui.adaptor.OrderItemAdapter;
import com.udeni.e_commerce_system_development_task.databinding.FragmentViewOrderListBinding;
import com.udeni.e_commerce_system_development_task.data.local.model.Order;
import com.udeni.e_commerce_system_development_task.viewmodel.OrderListViewmodel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ViewOrderListFragment extends Fragment {
    private FragmentViewOrderListBinding binding;
    private OrderListViewmodel orderListViewmodel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentViewOrderListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        orderListViewmodel = new ViewModelProvider(this).get(OrderListViewmodel.class);
        binding.setLifecycleOwner(this);
        binding.setOrderListVM(orderListViewmodel);
        // Observe the order list
//        orderListViewmodel.getOrderList().observe(getViewLifecycleOwner(), ordersWithItems -> {
//            if (ordersWithItems != null) {
//                List<com.udeni.e_commerce_system_development_task.model.Order> modelOrders = orderListViewmodel.convertToModelOrders(ordersWithItems);
//                OrderItemAdapter itemAdapter = new OrderItemAdapter(modelOrders);
//                itemAdapter.setOnItemClickListener(order -> openOrderDetailsFragment(order));
//
//                RecyclerView recyclerView = view.findViewById(R.id.orderListRecyclerView);
//                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//                recyclerView.setAdapter(itemAdapter);
//            }
//        });

        orderListViewmodel.getAllOrdersWithItems().observe(getViewLifecycleOwner(), ordersWithItems -> {
            List<Order> modelOrders = orderListViewmodel.convertToModelOrders(ordersWithItems);
            OrderItemAdapter itemAdapter = new OrderItemAdapter(modelOrders);
            itemAdapter.setOnItemClickListener(order -> openOrderDetailsFragment(order));

            RecyclerView recyclerView = view.findViewById(R.id.orderListRecyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(itemAdapter);
        });
        orderListViewmodel.saveDataToDatabase();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void openOrderDetailsFragment(Order order) {
        ViewOrderFragment fragment = new ViewOrderFragment();
        Bundle args = new Bundle();

        args.putParcelable("order", order);
        fragment.setArguments(args);

        getParentFragmentManager().beginTransaction()
                .replace(R.id.fl_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }
}