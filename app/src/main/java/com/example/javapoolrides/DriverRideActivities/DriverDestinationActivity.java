package com.example.javapoolrides.DriverRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.javapoolrides.DriverHomeActivity;
import com.example.javapoolrides.R;

public class DriverDestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_destination);
        setTitle("Destination");
    }

    public void more(View v) {
        String driverName = getIntent().getStringExtra("driver");
        Intent i = new Intent(this, RideHomeActivity.class);
        i.putExtra("driver",driverName);
        i.putExtra("from","QR");
        startActivity(i);
    }


    public void goHome(View v) {
        String driverName = getIntent().getStringExtra("driver");
        Intent i = new Intent(this, DriverHomeActivity.class);
        i.putExtra("username",driverName);
        startActivity(i);
    }
}