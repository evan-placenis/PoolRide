package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.javapoolrides.CustomerHomeActivity;
import com.example.javapoolrides.R;

public class RidePrefsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_prefs);
        setTitle("Choose ride preferences");
    }

    public void submitPrefs (View v) {
        Intent i = new Intent(this, ViewRidesActivity.class);
        startActivity(i);
    }

    public void home (View v){
        Intent i = new Intent(this, CustomerHomeActivity.class);
        startActivity(i);
    }
}