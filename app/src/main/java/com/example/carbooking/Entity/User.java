package com.example.carbooking.Entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "User",
        foreignKeys = @ForeignKey(entity = Role.class, parentColumns = "id", childColumns = "id"))
public class User {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    @ColumnInfo(name = "id")
    private int id;

    @NotNull
    @ColumnInfo(name = "username")
    private String userName;

    @NotNull
    @ColumnInfo(name = "Password")
    private String email;

    @NotNull
    @ColumnInfo(name = "PhoneNumber")
    private String phoneNumber;

    @NotNull
    @ColumnInfo(name = "Address")
    private String Address;

    @NotNull
    @ColumnInfo(name = "RoleId")
    private int Role_id;

    @NotNull
    @ColumnInfo(name = "IsLocked")
    private boolean isLocked;
    @ColumnInfo(name = "Avatar")
    private String avatar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NotNull String userName) {
        this.userName = userName;
    }

    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    @NotNull
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @NotNull
    public String getAddress() {
        return Address;
    }

    public void setAddress(@NotNull String address) {
        Address = address;
    }

    public int getRole_id() {
        return Role_id;
    }

    public void setRole_id(int role_id) {
        Role_id = role_id;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
