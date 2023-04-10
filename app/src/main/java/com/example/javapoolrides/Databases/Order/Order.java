package com.example.javapoolrides.Databases.Order;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.javapoolrides.Databases.Customer.Customer;

@Entity
public class Order {
    //key to distinguish the object
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "driver")
    public String driver;

    @ColumnInfo(name = "seatsAvail")
    public String seatsAvail;

    @ColumnInfo(name = "location")
    public String location;

    @ColumnInfo(name = "petFriendly")
    public String petFriendly;

    @ColumnInfo(name = "accessibility ")
    public String accessibility ;

    @ColumnInfo(name = "q1")
    public String q1;

    @ColumnInfo(name = "q2")
    public String q2;

    @ColumnInfo(name = "q3")
    public String q3;


    public Order(String driver, String seatsAvail, String location, String petFriendly, String accessibility ,String q1, String q2, String q3) {
        this.driver = driver;
        this.seatsAvail = seatsAvail;
        this.location = location;
        this.petFriendly= petFriendly;
        this.accessibility = accessibility;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }
}
