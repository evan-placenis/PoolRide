package com.example.javapoolrides.Databases.Order;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Order {
    //key to distinguish the object
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "driver")
    public String driver;

    @ColumnInfo(name = "seats")
    public String seats;

    @ColumnInfo(name = "location")
    public String location;

    @ColumnInfo(name = "preferences")
    public String preferences;

    public Order(String driver, String seats, String location, String preferences) {
        this.driver = driver;
        this.seats = seats;
        this.location = location;
        this.preferences = preferences;

    }
}
