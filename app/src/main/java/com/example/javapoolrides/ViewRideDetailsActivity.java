package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ViewRideDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ride_details);
        setTitle("Ride details");
    }

}