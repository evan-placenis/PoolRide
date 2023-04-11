package com.example.javapoolrides.Databases.ScheduledRides;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.javapoolrides.Databases.Order.Order;

import java.util.List;

@Dao
public interface ScheduleDao {
    @Insert
    void insertAll(Schedule... schedule);

    @Delete
    void delete(Schedule schedule);

    @Update
    void update(Schedule schedule);

    @Query("SELECT * FROM schedule")
    List<Schedule> getAllSchedules();

}
