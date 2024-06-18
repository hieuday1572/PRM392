package com.example.carbooking.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.carbooking.Entity.User;

import java.util.List;
@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(User user);
    @Query("SELECT * FROM User u  WHERE u.id =:userId")
    User select(int userId);
    @Query("SELECT * FROM User ")
    List<User> selectAll();
    @Query("DELETE FROM User")
    void deleteAll();
}
