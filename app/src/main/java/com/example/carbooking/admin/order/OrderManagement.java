package com.example.carbooking.admin.order;// ListOrder.java

import static com.example.carbooking.R.layout.activity_tour_histories;
import static com.example.carbooking.R.layout.activity_tour_management;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carbooking.Entity.Order;
import com.example.carbooking.R;
import com.example.carbooking.adapter.AdminOrderAdapter;
import com.example.carbooking.adapter.OrderAdapter;
import com.example.carbooking.repository.OrderRepository;

import java.util.List;

public class OrderManagement extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdminOrderAdapter orderAdapter;
    private OrderRepository orderRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_tour_management);

        recyclerView = findViewById(R.id.admin_tour_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        orderRepository = new OrderRepository(this);
        List<Order> orderList = orderRepository.getAllOrder();

        orderAdapter = new AdminOrderAdapter(this, orderList);
        recyclerView.setAdapter(orderAdapter);
    }
}
