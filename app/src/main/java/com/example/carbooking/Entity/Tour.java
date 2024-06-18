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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    public String getTile() {
        return tile;
    }

    public void setTile(@NotNull String tile) {
        this.tile = tile;
    }

    @NotNull
    public String getLocationFrom() {
        return locationFrom;
    }

    public void setLocationFrom(@NotNull String locationFrom) {
        this.locationFrom = locationFrom;
    }

    @NotNull
    public String getLocationTo() {
        return locationTo;
    }

    public void setLocationTo(@NotNull String locationTo) {
        this.locationTo = locationTo;
    }

    @NotNull
    public String getTourTime() {
        return tourTime;
    }

    public void setTourTime(@NotNull String tourTime) {
        this.tourTime = tourTime;
    }

    @NotNull
    public Date getDateNumber() {
        return dateNumber;
    }

    public void setDateNumber(@NotNull Date dateNumber) {
        this.dateNumber = dateNumber;
    }

    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }

    @NotNull
    public String getTourSchdule() {
        return tourSchdule;
    }

    public void setTourSchdule(@NotNull String tourSchdule) {
        this.tourSchdule = tourSchdule;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    @NotNull
    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(@NotNull String vehicle) {
        this.vehicle = vehicle;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getVotedNumber() {
        return votedNumber;
    }

    public void setVotedNumber(int votedNumber) {
        this.votedNumber = votedNumber;
    }

    public int getVoteScore() {
        return voteScore;
    }

    public void setVoteScore(int voteScore) {
        this.voteScore = voteScore;
    }

    public boolean isAvaliable() {
        return isAvaliable;
    }

    public void setAvaliable(boolean avaliable) {
        isAvaliable = avaliable;
    }

    @NotNull
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(@NotNull String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
