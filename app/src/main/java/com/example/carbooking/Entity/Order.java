package com.example.carbooking.Entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Entity(tableName = "Order", foreignKeys ={
        @ForeignKey(entity =  Status.class, parentColumns = "id", childColumns = "id"),
        @ForeignKey(entity = Tour.class, parentColumns = "id", childColumns = "id"),
        @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "id")
            })
public class Order {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "id")
    private int id;
    @NotNull
    @ColumnInfo(name = "tourId")
    private  int tourId;
    @NotNull
    @ColumnInfo(name = "numberOfPerson")
    private int numberOfPerson;
    @NotNull
    @ColumnInfo(name = "departureDay")
    private int departureDay;
    @NotNull
    @ColumnInfo(name = "totalFee")
    private double totalFee;
    @NotNull
    @ColumnInfo(name = "statusId")
    private boolean statusId;
    @NotNull
    @ColumnInfo(name = "orderDate")
    private Date orderDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public int getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(int departureDay) {
        this.departureDay = departureDay;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public boolean isStatusId() {
        return statusId;
    }

    public void setStatusId(boolean statusId) {
        this.statusId = statusId;
    }

    @NotNull
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(@NotNull Date orderDate) {
        this.orderDate = orderDate;
    }
}
