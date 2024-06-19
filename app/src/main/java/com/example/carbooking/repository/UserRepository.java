package com.example.carbooking.repository;

import android.content.Context;

import com.example.carbooking.Entity.User;
import com.example.carbooking.dao.PRM392RoomDatabase;
import com.example.carbooking.dao.UserDao;

import java.util.List;

public class UserRepository {
    private UserDao userDao;
    public  UserRepository(Context context){
        userDao = PRM392RoomDatabase.getInstance(context).userDao();
    }
    public void createUser(User user){
        userDao.insert(user);
    }

    public void updateUser(User user){
        userDao.update(user);
    }

    public User getUser(int userId){
        return  userDao.select(userId);
    }
    public User getUserByUsernameAndPassword(String username, String password){
        return  userDao.select(username,password);
    }
    public List<User> getAllUser(){
        return  userDao.selectAll();
    }
}
