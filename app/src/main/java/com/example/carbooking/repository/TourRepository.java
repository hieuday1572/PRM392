package com.example.carbooking.repository;

import android.content.Context;

import com.example.carbooking.Entity.Tour;
import com.example.carbooking.dao.PRM392RoomDatabase;
import com.example.carbooking.dao.TourDao;

import java.util.List;

public class TourRepository {
    private TourDao tourDao;
    public  TourRepository(Context context){
        tourDao = PRM392RoomDatabase.getInstance(context).tourDao();
    }
    public void createTour(Tour tour){
        tourDao.insert(tour);
    }

    public void updateTour(Tour tour){
        tourDao.update(tour);
    }

    public Tour getTour(int tourId){
        return  tourDao.select(tourId);
    }

    public List<Tour> getAllTour(){
        return  tourDao.selectAll();
    }
}
