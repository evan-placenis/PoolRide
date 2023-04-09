package com.example.javapoolrides.Databases.Driver;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Driver.class},version = 1)
public abstract class DriverDatabase extends RoomDatabase{
    public abstract DriverDao driverDao();

}
