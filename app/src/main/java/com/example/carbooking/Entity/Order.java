package com.example.carbooking.Entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

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
}
