package com.example.javapoolrides.Databases.Driver;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Driver {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "password")
    public String password;


    public Driver(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
