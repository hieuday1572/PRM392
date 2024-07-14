package com.example.carbooking.OrderTour;// ListOrder.java
import static com.example.carbooking.R.layout.activity_tour_histories;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.carbooking.Entity.Order;
import com.example.carbooking.R;
import com.example.carbooking.adapter.OrderAdapter;
import com.example.carbooking.repository.OrderRepository;
import java.util.List;

public class ListOrder extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;
    private OrderRepository orderRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_tour_histories);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        orderRepository = new OrderRepository(this);
        List<Order> orderList = orderRepository.getAllOrder();

        orderAdapter = new OrderAdapter(this, orderList);
        recyclerView.setAdapter(orderAdapter);
    }
}
