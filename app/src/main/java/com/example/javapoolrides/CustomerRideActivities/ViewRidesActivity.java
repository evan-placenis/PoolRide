package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.javapoolrides.CustomerHomeActivity;
import com.example.javapoolrides.R;

public class ViewRidesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rides);
        setTitle("Choose your ride");
    }

    public void selectRide (View v) {
        Intent i = new Intent(this, CustomerRideActivity.class);
        startActivity(i);
    }

    public void cancelRide (View v) {
        Intent i = new Intent(this, CustomerHomeActivity.class);
        startActivity(i);
    }
}