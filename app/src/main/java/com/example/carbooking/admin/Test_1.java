package com.example.carbooking.admin;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.carbooking.R;
import com.google.android.material.navigation.NavigationView;

public class Test_1 extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageButton buttonDrawerToggle;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_test1);

        buttonDrawerToggle = findViewById(R.id.button_drawerToggle);
        System.out.println("buttonDrawerToggle : " + buttonDrawerToggle);

        drawerLayout = findViewById(R.id.maintest1);
        System.out.println("drawerLayout : " + drawerLayout);
        navigationView = findViewById(R.id.navigationViewTest1);
        System.out.println("navigationViewTest1 : " + navigationView);
        buttonDrawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });

        View headerView = navigationView.getHeaderView(0);
        ImageView adminImage = headerView.findViewById(R.id.imgAdmin);
        TextView txtUserName = headerView.findViewById(R.id.txtUserName);

        adminImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Test_1.this,txtUserName.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int itemId = menuItem.getItemId();

                if(itemId == R.id.navAddTour){
                    Toast.makeText(Test_1.this, "Add clicked", Toast.LENGTH_SHORT).show();
                }
                if(itemId == R.id.navEditTour){
                    Toast.makeText(Test_1.this, "Edit clicked", Toast.LENGTH_SHORT).show();
                }
                if(itemId == R.id.navRemoveTour){
                    Toast.makeText(Test_1.this, "Remove clicked", Toast.LENGTH_SHORT).show();
                }
                if(itemId == R.id.navFavorite){
                    Toast.makeText(Test_1.this, "Favorited clicked", Toast.LENGTH_SHORT).show();
                }
                if(itemId == R.id.navReport){
                    Toast.makeText(Test_1.this, "Report clicked", Toast.LENGTH_SHORT).show();
                }
                if(itemId == R.id.navHistory){
                    Toast.makeText(Test_1.this, "History clicked", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.close();


                return false;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.maintest1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}