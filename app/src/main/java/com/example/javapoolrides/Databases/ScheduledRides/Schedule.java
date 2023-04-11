package com.example.javapoolrides.Databases.ScheduledRides;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Schedule {

    //key to distinguish the object
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "time")
    public String time;

    @ColumnInfo(name = "destinationLoc")
    public String destinationLoc;

    @ColumnInfo(name = "pickupLoc")
    public String pickupLoc;

    @ColumnInfo(name = "username")
    public String username;

    public Schedule(String date, String time, String destinationLoc, String pickupLoc, String username){
        this.date = date;
        this.time = time;
        this.destinationLoc = destinationLoc;
        this.pickupLoc = pickupLoc;
        this.username = username;

    }
}
