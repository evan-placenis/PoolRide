package com.example.javapoolrides.Databases.Order;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.javapoolrides.Databases.Customer.Customer;

@Database(entities = {Order.class},version = 1)
public abstract class OrderDatabase extends RoomDatabase {
    public abstract OrderDao orderDao();
}
