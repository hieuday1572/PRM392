package com.example.carbooking.user;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.carbooking.Entity.Tour;
import com.example.carbooking.R;
import com.example.carbooking.databinding.ActivityTourDetailBinding;
import com.example.carbooking.helpler.FormatUtils;
import com.example.carbooking.repository.CategoryRepository;
import com.example.carbooking.repository.VehicleRepository;

public class TourDetailActivity extends AppCompatActivity {
    public static final String KEY_TOUR = "tour";

    private ActivityTourDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTourDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        populateData();
    }

    @SuppressLint("SetTextI18n")
    private void populateData() {
        Tour tour = (Tour) getIntent().getSerializableExtra(KEY_TOUR);
        if (tour == null) return;

        // Bind data
        Glide.with(this)
                .load(tour.getImage())
                .error(R.drawable.placeholder)
                .into(binding.imageTourDetail);
        binding.textTitle.setText(tour.getTile());
        binding.textPrice.setText(FormatUtils.formatCurrency(tour.getPricePerPerson()) + "VNĐ/");
        binding.textFrom.setText(tour.getLocationFrom());
        binding.textTo.setText(tour.getLocationTo());
        binding.textTourTime.setText(tour.getTourTime());
        binding.textTourDateNumber.setText(tour.getDateNumber() + "");
        binding.textTourSchedule.setText(tour.getTourSchdule());
        binding.textContact.setText(tour.getContactNumber());
        binding.textDescription.setText(tour.getDescription());

        // Bind category and vehicle
        String categoryName = new CategoryRepository(this).getCategory(tour.getCategoryId()).getCategoryName();
        String vehicleName = new VehicleRepository(this).getVehicle(tour.getVehicle()).getVehicleName();
        binding.textCategory.setText(categoryName);
        binding.textVehicle.setText(vehicleName);

        // Set listeners
        binding.iconBack.setOnClickListener(v -> finish());
    }
}