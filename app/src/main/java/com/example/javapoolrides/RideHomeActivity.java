package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.sql.Driver;

public class RideHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_home);
        setTitle("Ride Homepage");
    }

    public void acceptRide(View v){
        //launch a new activity

        Intent i = new Intent(this, AcceptRideActivity.class);
        startActivity(i);
    }

    public void home(View v){
        //launch a new activity

        Intent i = new Intent(this, DriverHomeActivity.class);
        startActivity(i);
    }
}