package com.example.javapoolrides.Databases.Order;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface OrderDao {
    @Insert
    void insertAll(Order... order);

    @Delete
    void delete(Order order);

    @Update
    void update(Order order);

//    @Query("DELETE FROM [order]")
//    void deleteUser();

    @Query("SELECT * FROM [order]")
    List<Order> getAllOrders();
}
