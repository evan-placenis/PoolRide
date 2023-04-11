package com.example.javapoolrides.DriverRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.javapoolrides.DriverHomeActivity;
import com.example.javapoolrides.R;

public class RideHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_home);
        setTitle("Ride Home");
    }
    public void endOffer(View v){
        //ADD LOGIC TO DELETE USER FROM ORDER DATABASE

        Intent i = new Intent(this, DriverHomeActivity.class);
        startActivity(i);

    }
}