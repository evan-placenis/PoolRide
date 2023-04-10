package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.javapoolrides.R;

public class ViewRideDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ride_details);
        setTitle("Ride details");

//        String username = getIntent().getStringExtra("username");
//        i.putExtra("username", username);
    }

}