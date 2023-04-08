package com.example.javapoolrides.Databases.Customer;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.javapoolrides.Databases.Customer.Customer;

import CustomerDao;

@Database(entities = {Customer.class},version = 1)
public abstract class CustomerDatabase extends RoomDatabase {
    public abstract CustomerDao customerDao();

}
