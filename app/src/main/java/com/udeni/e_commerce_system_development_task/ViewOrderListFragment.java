package com.udeni.e_commerce_system_development_task;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.udeni.e_commerce_system_development_task.adaptor.OrderItemAdapter;
import com.udeni.e_commerce_system_development_task.databinding.FragmentViewOrderListBinding;
import com.udeni.e_commerce_system_development_task.model.Order;
import com.udeni.e_commerce_system_development_task.model.ParcelableOrderItem;
import com.udeni.e_commerce_system_development_task.viewmodel.OrderListViewmodel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ViewOrderListFragment extends Fragment {
    //Create Databinding
    private FragmentViewOrderListBinding binding;
    private OrderListViewmodel orderListViewmodel;

    //Initialize ViewModel
//    private val viewModel: ProfileViewModel by viewModels()
//    ///Get Activity Context to pass to ProfileViewModel
//    private var activity: Activity? = null
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_view_order_list, container, false);
//        binding = DataBindingUtil.inflate(
//                inflater, R.layout.fragment_view_order_list, container, false);
        binding = FragmentViewOrderListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        orderListViewmodel = new ViewModelProvider(this).get(OrderListViewmodel.class);
        binding.setLifecycleOwner(this);
        binding.setOrderListVM(orderListViewmodel);
        orderListViewmodel.getOrders();
// Create the observer which updates the UI.
        final Observer<List<com.udeni.e_commerce_system_development_task.database.entity.Order>> orderListObserver = new Observer<List<com.udeni.e_commerce_system_development_task.database.entity.Order>>() {
            @Override
            public void onChanged(@Nullable final List<com.udeni.e_commerce_system_development_task.database.entity.Order> orderList) {
                // Update the UI, in this case, a TextView.
//                binding.textView.setText("size"+apiResponse.customers.size());
//                if(binding.getOrderListVM().getApiResponse().getValue() !=null) {
// Assign employeelist to ItemAdapter
//                    List<ApiOrder> orders = binding.getOrderListVM().getApiResponse().getValue().orders;
                List<com.udeni.e_commerce_system_development_task.model.Order> modelOrders=new ArrayList<>();

            for(com.udeni.e_commerce_system_development_task.database.entity.Order order:orderList){
                com.udeni.e_commerce_system_development_task.model.Order modelOrder=new com.udeni.e_commerce_system_development_task.model.Order();
                modelOrder.setOrderNumber(String.valueOf(order.getReceiptNumber()));
                modelOrders.add(modelOrder);
            }
                OrderItemAdapter itemAdapter = new OrderItemAdapter(modelOrders);
                itemAdapter.setOnItemClickListener(new OrderItemAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Order order) {
                        openOrderDetailsFragment(order);
                    }
                });
//                itemAdapter.setOnItemClickListener(new );

                RecyclerView recyclerView = view.findViewById(R.id.recycleView);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                // adapter instance is set to the
                // recyclerview to inflate the items.
                recyclerView.setAdapter(itemAdapter);

//                }
                if (orderList!=null) {
                    Log.d("*************", "sizeeee" + orderList.size());
                }
            }
        };
//        final Observer<List<com.udeni.e_commerce_system_development_task.database.entity.Order>> nameObserver1 = new Observer<List<com.udeni.e_commerce_system_development_task.database.entity.Order>>() {
//            @Override
//            public void onChanged(@Nullable final List<com.udeni.e_commerce_system_development_task.database.entity.Order> orderList) {
//                if(orderList!=null) {
//                    Log.d("*************", "size" + orderList.size());
//                }
//
//            }
//        };
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        orderListViewmodel.getOrderList().observe(getViewLifecycleOwner(), orderListObserver);
//        orderListViewmodel.getDbOrderList().observe(getViewLifecycleOwner(), nameObserver1);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //    private void openOrderDetailsFragment(ParcelableOrderItem orderItem) {
//        ViewOrderFragment fragment = new ViewOrderFragment();
//        Bundle args = new Bundle();args.putParcelable("orderItem", orderItem); // Assuming OrderItem is Parcelable
//        fragment.setArguments(args);
//
//        // Replace the current fragment with the new fragment
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fl_fragment, fragment)
//                .addToBackStack(null)
//                .commit();
//    }
    private void openOrderDetailsFragment(Order order) {
        ViewOrderFragment fragment = new ViewOrderFragment();
        Bundle args = new Bundle();
        ParcelableOrderItem parcelableOrderItem = new ParcelableOrderItem(
                String.valueOf(order.getOrderItems().get(0).getItemCode()),
                order.getOrderItems().get(0).getQty(),
                order.getOrderItems().get(0).getItemPrice()
        );
        args.putParcelable("orderItem", parcelableOrderItem); // Assuming ApiOrderItem is Parcelable
        fragment.setArguments(args);

        getParentFragmentManager().beginTransaction()
                .replace(R.id.fl_fragment, fragment) // Replace with your container ID
                .addToBackStack(null)
                .commit();
    }
}