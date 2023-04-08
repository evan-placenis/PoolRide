package com.example.javapoolrides;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CustomerDao {
    @Insert
    void insertAll(Customer... customers);

    @Query("SELECT * FROM customer")
    List<Customer> getAllCustomers();


}
