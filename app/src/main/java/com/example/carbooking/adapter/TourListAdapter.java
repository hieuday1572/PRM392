package com.example.carbooking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carbooking.Entity.Tour;
import com.example.carbooking.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TourListAdapter extends RecyclerView.Adapter<TourListAdapter.TourViewHolder> {
    private List<Tour> tours = null;
    private Context context;

    public TourListAdapter(List<Tour> tours, Context context) {
        this.tours = tours;
        this.context = context;
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_tour, parent ,false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        Tour tour = tours.get(position);
        holder.tvTourTitle.setText("" + tour.getTile());
        holder.tvlocationFrom.setText("" + tour.getLocationFrom());
        holder.tvlocationTo.setText("" + tour.getLocationTo());
        holder.tvTourTime.setText("" + tour.getTourTime());
        holder.tvPricePerPerson.setText("" + tour.getPricePerPerson());
    }

    @Override
    public int getItemCount() {
        return tours.size();
    }

    public class TourViewHolder extends RecyclerView.ViewHolder{
        private TextView tvTourTitle, tvlocationFrom,
                tvlocationTo, tvTourTime, tvPricePerPerson;
        public TourViewHolder (@NotNull View itemView){
            super(itemView);
            tvTourTitle = itemView.findViewById(R.id.tv_tour_title);
            tvlocationFrom = itemView.findViewById(R.id.tv_location_from);
            tvlocationTo = itemView.findViewById(R.id.tv_location_to);
            tvTourTime = itemView.findViewById(R.id.tv_tour_time);
            tvPricePerPerson = itemView.findViewById(R.id.tv_price_per_person);
        }
    }
}

