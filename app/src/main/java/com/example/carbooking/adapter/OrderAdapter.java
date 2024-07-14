package com.example.carbooking.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carbooking.Entity.Order;
import com.example.carbooking.Entity.Tour;
import com.example.carbooking.OrderTour.OrderDetailActivity;
import com.example.carbooking.R;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private Context context;
    private List<Order> orderList;
    private List<Tour> tourList;

    public OrderAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_item, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = orderList.get(position);

        // Hiển thị dữ liệu trong ViewHolder
        holder.nameTour.setText("Tour: " + order.getTourId());
        holder.statusTour.setText("Status: " + (order.getStatusId() == 1 ? "Completed" : "Pending"));
        holder.priceTour.setText("Price: " + order.getTotalFee());


        holder.btnHistoryDetail.setOnClickListener(view -> {
            Intent intent = new Intent(context, OrderDetailActivity.class);
            intent.putExtra("orderId", order.getId());
            intent.putExtra("tourId", order.getTourId());
            intent.putExtra("fee", order.getTotalFee());
            intent.putExtra("statusId", order.getStatusId());
            intent.putExtra("userId", order.getUserId());
            intent.putExtra("numPer", order.getNumberOfPerson());
            intent.putExtra("orderDay", order.getOrderDate());
            intent.putExtra("departDay", order.getDepartureDay());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView nameTour, statusTour, priceTour;
        ImageView imgTour;
        Button btnHistoryDetail;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTour = itemView.findViewById(R.id.name_tour);
            statusTour = itemView.findViewById(R.id.status_tour);
            priceTour = itemView.findViewById(R.id.price_tour);
            imgTour = itemView.findViewById(R.id.img_tour);
            btnHistoryDetail = itemView.findViewById(R.id.btnHistoryDetail);
        }

    }

}
