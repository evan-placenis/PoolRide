package com.example.javapoolrides;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CustomerDao {
    @Insert
    void insertAll(Customer... customers);

    @Delete
    void delete(Customer customer);

    @Update
    void update(Customer customer);

    @Query("SELECT * FROM customer")
    List<Customer> getAllCustomers();


}
