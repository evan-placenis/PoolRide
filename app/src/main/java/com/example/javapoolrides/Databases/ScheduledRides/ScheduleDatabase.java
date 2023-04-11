package com.example.javapoolrides.Databases.ScheduledRides;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.javapoolrides.Databases.Order.Order;
import com.example.javapoolrides.Databases.Order.OrderDao;

@Database(entities = {Schedule.class},version = 1)
public abstract class ScheduleDatabase extends RoomDatabase {
    public abstract ScheduleDao scheduleDao();
}
