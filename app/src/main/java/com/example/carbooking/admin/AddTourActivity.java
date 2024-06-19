package com.example.carbooking.admin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.carbooking.Entity.Category;
import com.example.carbooking.Entity.Tour;
import com.example.carbooking.Entity.Vehicle;
import com.example.carbooking.R;
import com.example.carbooking.repository.CategoryRepository;
import com.example.carbooking.repository.TourRepository;
import com.example.carbooking.repository.VehicleRepository;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class AddTourActivity extends AppCompatActivity {
    private Spinner spinnerCategory, spinnerVehicle;
    private int vehicleId, categoryId;
    public TourRepository tourRepository = null;
    public CategoryRepository categoryRepository = null;
    public VehicleRepository vehicleRepository = null;
    private List<Category> categoryList;
    private List<Vehicle> vehicleList = null;
    private ImageButton btnBack;
    private EditText edtTitle,edtLocationFrom,edtLocationTo,edtTourTime,
            edtDateNumber,edtPricePerPerson,edtContact,edtDescription, edtTourSchedule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_tour);


        categoryRepository = new CategoryRepository(this);
        tourRepository = new TourRepository(this);
        vehicleRepository = new VehicleRepository(this);


        Button btnSave = findViewById(R.id.btn_addTour);
        edtTitle = findViewById(R.id.edt_title_tour);
        edtLocationFrom = findViewById(R.id.edt_location_from);
        edtLocationTo = findViewById(R.id.edt_location_to);
        edtTourTime = findViewById(R.id.edt_tour_time);
        edtDateNumber = findViewById(R.id.edt_date_number);
        edtPricePerPerson = findViewById(R.id.edt_price_person);
        edtContact = findViewById(R.id.edt_contact_number);
        edtDescription = findViewById(R.id.edt_description_tour);
        spinnerCategory = findViewById(R.id.spinner_category);
        spinnerVehicle = findViewById(R.id.spinner_vehicle);
        edtTourSchedule = findViewById(R.id.edt_tour_schedule);
        //get listcategory
        try {
            categoryList = categoryRepository.getAllCategory();
            System.out.println("List" + categoryList);
            ArrayAdapter<Category> arrayAdapterCategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categoryList);
            arrayAdapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerCategory.setAdapter(arrayAdapterCategory);
            spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Category selectedCategory = (Category) parent.getItemAtPosition(position);
                        categoryId = selectedCategory.getId();
                        Toast.makeText(AddTourActivity.this, "Selected categoryName= " + selectedCategory, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        //-------------------------

            //get list vehicle
        try {
            vehicleList = vehicleRepository.getAllVehicle();
            ArrayAdapter<Vehicle> arrayAdapterVehicle = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, vehicleList);
            arrayAdapterVehicle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerVehicle.setAdapter(arrayAdapterVehicle);
            spinnerVehicle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Vehicle selectedVehicle = (Vehicle) parent.getItemAtPosition(position);
                    vehicleId = selectedVehicle.getId();
                    String vehicleName = selectedVehicle.getVehicleName();
                    Toast.makeText(AddTourActivity.this, "Selected vehicle= " + vehicleName, Toast.LENGTH_LONG).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        //------------------------

            btnBack = findViewById(R.id.back_homepage_admin);
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AddTourActivity.this, HomePageAdminActivity.class);
                    startActivity(intent);
                }
            });



            btnSave.setOnClickListener(new View.OnClickListener() {
                public int checkInputInteger(){
                    try{
                        int dateNumber = Integer.parseInt(edtDateNumber.getText().toString());
                        if(dateNumber < 0){
                            edtDateNumber.setError("Number is greater than 0");
                        }else{
                            return dateNumber;
                        }
                    }catch (Exception e){
                        edtDateNumber.setError("edtDateNumber is is required");
                    }
                    return 0;
                }
                public double checkInputDouble(){
                    try{
                        double pricePerPerson = Double.parseDouble(edtPricePerPerson.getText().toString());
                        if(pricePerPerson < 0){
                            edtPricePerPerson.setError("Number is greater than 0");
                        }else{
                            return pricePerPerson;
                        }
                    }catch (Exception e){
                        edtPricePerPerson.setError("Number is is required");
                    }
                    return 0;
                }

                @Override
                public void onClick(View v) {
                    String title = edtTitle.getText().toString();
                    String locationFrom = edtLocationFrom.getText().toString();
                    String locationTo = edtLocationTo.getText().toString();
                    String tourTime = edtTourTime.getText().toString();
                    int dateNumber = checkInputInteger();
                    double pricePerPerson = checkInputDouble();
                    String contact = edtContact.getText().toString();
                    String description = edtDescription.getText().toString();
                    String tourSchedule = edtTourSchedule.getText().toString();
                    boolean flag = true;
                    if (title.trim().isEmpty()) {
                        edtTitle.setError("Title is required");
                        flag = false;
                    }

                    if (locationFrom.trim().isEmpty()) {
                        edtLocationFrom.setError("Location From is required");
                        flag = false;
                    }

                    if (locationTo.trim().isEmpty()) {
                        edtLocationTo.setError("Location To is required");
                        flag = false;
                    }

                    if (tourTime.trim().isEmpty()) {
                        edtTourTime.setError("Tour Time is required");
                        flag = false;
                    }

                    if (contact.trim().isEmpty()) {
                        edtContact.setError("Contact is required");
                        flag = false;
                    }

                    if (description.trim().isEmpty()) {
                        edtDescription.setError("Description is required");
                        flag = false;
                    }

                    if (tourSchedule.trim().isEmpty()) {
                        edtTourSchedule.setError("Tour Schedule is required");
                        flag = false;
                    }

                    boolean isActive = true;
                    int votedNumber = 0;
                    int voteScore = 1;
                    Tour newTour = new Tour(
                            title,
                            locationFrom,
                            locationTo,
                            tourTime,
                            dateNumber,
                            description,
                            tourSchedule,
                            pricePerPerson,
                            vehicleId,
                            categoryId,
                            votedNumber,
                            voteScore,
                            isActive,
                            contact);
                    if(flag){
                        tourRepository.createTour(newTour);
                        Toast.makeText(AddTourActivity.this, "success: " + flag, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AddTourActivity.this, HomePageAdminActivity.class);
                        startActivity(intent);
                    }

                }
            });
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        }

}