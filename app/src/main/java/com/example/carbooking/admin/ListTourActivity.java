package com.example.carbooking.admin;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carbooking.Entity.Tour;
import com.example.carbooking.R;
import com.example.carbooking.adapter.TourListAdapter;
import com.example.carbooking.repository.TourRepository;

import java.util.List;

public class ListTourActivity extends AppCompatActivity {
    private TourRepository tourRepository = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_tour);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tourRepository = new TourRepository(this);
        RecyclerView recyclerView = findViewById(R.id.tour_list_recyle_view);
        List<Tour> tourList = tourRepository.getAllTour();
        TourListAdapter tourListAdapter = new TourListAdapter(tourList,this);
        recyclerView.setAdapter(tourListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}