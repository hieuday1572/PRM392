package com.example.carbooking.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.carbooking.Entity.Order;

import java.util.List;
@Dao
public interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert (Order order);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Order order);

    @Query("SELECT * FROM `Order` o WHERE o.id =:id")
    Order select(int id);

    @Query("SELECT * FROM `Order`")
    List<Order> selectAll();

    @Query("DELETE FROM `Order`")
    void deleteAll();
}
