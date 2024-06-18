package com.example.carbooking.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Entity(tableName = "Tour",
        foreignKeys = {
                @ForeignKey(entity = Category.class, parentColumns = "id", childColumns = "id"),
                @ForeignKey(entity = Vehicle.class, parentColumns = "id", childColumns = "id")
        })
public class Tour {
    @NotNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @NotNull
    @ColumnInfo(name = "tile")
    private String tile;
    @NotNull
    @ColumnInfo(name = "locationFrom")
    private String locationFrom;
    @NotNull
    @ColumnInfo(name = "locationTo")
    private String locationTo;
    @NotNull
    @ColumnInfo(name = "tourTime")
    private String tourTime;
    @NotNull
    @ColumnInfo(name = "dateNumber")
    private Date dateNumber;
    @NotNull
    @ColumnInfo(name = "description")
    private String description;
    @NotNull
    @ColumnInfo(name = "tourSchdule")
    private String tourSchdule;
    @NotNull
    @ColumnInfo(name = "pricePerPerson")
    private double pricePerPerson;
    @NotNull
    @ColumnInfo(name = "vehicle")
    private String vehicle;
    @NotNull
    @ColumnInfo(name = "categoryId")
    private int categoryId;
    @NotNull
    @ColumnInfo(name = "votedNumber")
    private int votedNumber;
    @NotNull
    @ColumnInfo(name = "voteScore")
    //note
    private int voteScore;
    @NotNull
    @ColumnInfo(name = "isAvaliable")
    private boolean isAvaliable;
    @NotNull
    @ColumnInfo(name = "contactNumber")
    private String contactNumber;


}
