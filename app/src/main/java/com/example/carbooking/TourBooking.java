package com.example.carbooking;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.carbooking.Entity.Order;
import com.example.carbooking.Entity.Tour;
import com.example.carbooking.Entity.User;
import com.example.carbooking.repository.OrderRepository;
import com.example.carbooking.repository.TourRepository;
import com.example.carbooking.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TourBooking extends AppCompatActivity {
    private TourRepository tourRepository = null;
    private UserRepository userRepository = null;
    private OrderRepository orderRepository = null;
    Button addCount, subCount, btnbooKing, btnSelectDate;
    int mCount=1;
    TextView txtCount, tvTitle, tvLocationFrom, tvLocationTo, tvTourTime, tvDescription,
            tvTourNumber, tvPricePerPerson, tvVoteScore, tvVoteNumber, tvContactNumber, priceTour, tvStartDate, tvEndDate;
    ImageView imgTour;
    double basePrice = 0.0;
    int dateNumber, userId = 1;
    SharedPreferences preferences;
    Tour firstTour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tour_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tourRepository = new TourRepository(this);
        userRepository = new UserRepository(this);
        orderRepository = new OrderRepository(this);
        List<Tour> tourList = tourRepository.getAllTour();
        preferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        int id = preferences.getInt("userId", 0);
//        User user = userRepository.getUserById(id);
//        userId = user.getId();


        txtCount = findViewById(R.id.txt_count);
        addCount = findViewById(R.id.btn_addCount);
        subCount = findViewById(R.id.btn_subCount);
        tvTitle = findViewById(R.id.tv_Tittle);
        tvLocationFrom = findViewById(R.id.tv_startLocation);
        tvLocationTo = findViewById(R.id.tv_endLocation);
        tvTourTime = findViewById(R.id.tv_tourTime);
        tvDescription = findViewById(R.id.tv_description);
        tvPricePerPerson = findViewById(R.id.tv_price);
        tvVoteScore = findViewById(R.id.tv_voteScore);
        tvVoteNumber = findViewById(R.id.tv_voteNumber);
        tvContactNumber = findViewById(R.id.tv_contact);
        imgTour = findViewById(R.id.img_tour);
        priceTour = findViewById(R.id.price_tour);
        tvStartDate = findViewById(R.id.tv_startDate);
        tvEndDate = findViewById(R.id.tv_endDate);
        btnSelectDate = findViewById(R.id.btn_selectDate);
        btnbooKing = findViewById(R.id.btn_confirm);

        if (!tourList.isEmpty()) {

            firstTour = tourList.get(0);
            basePrice = firstTour.getPricePerPerson();
            dateNumber = firstTour.getDateNumber();

            tvTitle.setText(firstTour.getTile());
            tvLocationFrom.setText(firstTour.getLocationFrom());
            tvLocationTo.setText(" - " + firstTour.getLocationTo());
            tvTourTime.setText(firstTour.getTourTime());

            tvDescription.setText(firstTour.getDescription());

            tvPricePerPerson.setText(String.format("$%.2f/person", firstTour.getPricePerPerson()));
            tvVoteScore.setText(String.format("%d*", firstTour.getVoteScore()));
            tvVoteNumber.setText(String.format("(%d)", firstTour.getVotedNumber()));
            tvContactNumber.setText(firstTour.getContactNumber());
            priceTour.setText("0");


            // Example: Glide.with(this).load(firstTour.getImage()).into(imgTour);
        }


        txtCount.setText(Integer.toString(mCount));

        addCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                txtCount.setText(Integer.toString(mCount));
                priceTour.setText(String.format("$%.2f", basePrice * mCount));
            }
        });

        subCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCount > 1) {
                    mCount--;
                    txtCount.setText(Integer.toString(mCount));
                    priceTour.setText(String.format("$%.2f", basePrice * mCount));
                }
            }
        });

        btnbooKing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createOrder();
            }
        });

        btnSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                TourBooking.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        updateDates(calendar);
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    private void updateDates(Calendar startDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        tvStartDate.setText(sdf.format(startDate.getTime()));
        startDate.add(Calendar.DAY_OF_MONTH, dateNumber);
        tvEndDate.setText(sdf.format(startDate.getTime()));
    }

    private void createOrder() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date startDate = sdf.parse(tvStartDate.getText().toString());
            Date endDate = sdf.parse(tvEndDate.getText().toString());
            Date orderDate = new Date();

            Order order = new Order();
            order.setTourId(firstTour.getId());
            order.setUserId(userId);
            order.setNumberOfPerson(mCount);
            order.setDepartureDay((int) (startDate.getTime() / (1000 * 60 * 60 * 24)));
            order.setTotalFee(basePrice * mCount);
            order.setStatusId(1);
            order.setOrderDate(orderDate);
            order.setEndDate(endDate);

            orderRepository.createOrder(order);

            Toast.makeText(this, "Booking Confirmed!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Failed to create order!", Toast.LENGTH_SHORT).show();
        }
    }
}