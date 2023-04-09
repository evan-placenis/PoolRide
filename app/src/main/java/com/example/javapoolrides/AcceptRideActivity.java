package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AcceptRideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accept_ride);
        setTitle("Accept Ride");
    }

    public void rideHomepage(View v){
        //launch a new activity

        Intent i = new Intent(this, ViewRidesActivity.class);
        startActivity(i);
    }
}