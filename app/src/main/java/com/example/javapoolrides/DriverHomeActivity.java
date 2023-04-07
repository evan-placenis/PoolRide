package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DriverHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_home);
        setTitle("Home");
    }

    public void offerRide(View v){
        //launch a new activity

        Intent i = new Intent(this, OfferRideActivity.class);
        startActivity(i);
    }
}