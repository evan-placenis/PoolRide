package com.example.javapoolrides.Databases.Customer;

import android.util.Log;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Customer {
    //key to distinguish the object
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "phone")
    public String phone;

    @ColumnInfo(name = "rating")
    public String rating;

    @ColumnInfo(name = "subscription")
    public Boolean subscription;

    @ColumnInfo(name = "firstname")
    public String firstName;

    @ColumnInfo(name = "lastname")
    public String lastName;

    @ColumnInfo(name = "q1")
    public String q1;

    @ColumnInfo(name = "q2")
    public String q2;

    @ColumnInfo(name = "q3")
    public String q3;

    public Customer(String username, String password, String email, String phone, String firstName, String lastName, String rating, String q1, String q2, String q3, Boolean subscription) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.subscription = subscription;

    }
}
