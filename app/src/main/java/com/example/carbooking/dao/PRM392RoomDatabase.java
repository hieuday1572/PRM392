package com.example.carbooking.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.carbooking.Entity.Category;
import com.example.carbooking.Entity.Order;
import com.example.carbooking.Entity.Role;
import com.example.carbooking.Entity.Status;
import com.example.carbooking.Entity.Tour;
import com.example.carbooking.Entity.User;
import com.example.carbooking.Entity.Vehicle;

@Database(entities = {Category.class, Order.class, Role.class, Status.class, Tour.class, User.class, Vehicle.class}, version = 1)
public abstract class PRM392RoomDatabase extends RoomDatabase {
    private static final String DB_NAME = "PRM392Database";
    public abstract CategoryDao categoryDao();
    public abstract UserDao userDao();
    public abstract OrderDao orderDao();
    public abstract RoleDao roleDao();
    public abstract StatusDao statusDao();
    public abstract TourDao tourDao();
    public abstract VehicleDao vehicleDao();

    private static PRM392RoomDatabase INSTANCE;

    public static synchronized PRM392RoomDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    PRM392RoomDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigrationFrom()
                    .enableMultiInstanceInvalidation()
                    .build();
        }
        return INSTANCE;
    }
}
