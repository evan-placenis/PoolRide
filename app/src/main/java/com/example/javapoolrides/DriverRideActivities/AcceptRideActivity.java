package com.example.javapoolrides.DriverRideActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.javapoolrides.CustomerRideActivities.ViewRidesActivity;
import com.example.javapoolrides.Databases.Order.Order;
import com.example.javapoolrides.Databases.Order.OrderDatabase;
import com.example.javapoolrides.R;

import java.util.List;

public class AcceptRideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_ride);
        setTitle("Accept Ride");
    }

    public void acceptRide(View v){
        //launch a new activity
        Intent i = new Intent(this, RideHomeActivity.class);
        OrderDatabase dbO = Room.databaseBuilder(getApplicationContext(),
                OrderDatabase.class, "order-database").allowMainThreadQueries().build();
        i.putExtra("from", "acceptRide");
        //UPDATE DATABASE

        startActivity(i);
    }

    public void declineRide(View v){

        Intent i = new Intent(this, RideHomeActivity.class);
        i.putExtra("from", "acceptRide");
        startActivity(i);

    }
}