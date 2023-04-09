package com.example.javapoolrides.Databases.Driver;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DriverDao {
    @Insert
    void insertAll(Driver... driver);

    @Delete
    void delete(Driver driver);

    @Update
    void update(Driver driver);

    @Query("SELECT * FROM driver")
    List<Driver> getAllDrivers();
}
