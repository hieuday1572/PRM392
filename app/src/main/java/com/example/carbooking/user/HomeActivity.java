package com.example.carbooking.user;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carbooking.databinding.ActivityHomeBinding;
import com.example.carbooking.repository.TourRepository;
import com.example.carbooking.user.adapter.TourAdapter;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private TourAdapter tourAdapter;
    private TourRepository tourRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initialize();
    }

    @Override
    protected void onResume() {
        super.onResume();
        tourAdapter.submitList(tourRepository.getAllTour());
    }

    private void initialize() {
        tourRepository = new TourRepository(this);
        binding.recyclerView.setAdapter(tourAdapter = new TourAdapter());
    }
}