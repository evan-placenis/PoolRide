package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.javapoolrides.CustomerHomeActivity;
import com.example.javapoolrides.R;
import com.google.android.gms.maps.MapView;

public class ArrivalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrival);
        setTitle("Arrival");
        MapView mapView = findViewById(R.id.Arrival);
        mapView.onCreate(savedInstanceState);
    }

    public void returnHome(View v) {
        Intent i = new Intent(this, CustomerHomeActivity.class);
        String username = getIntent().getStringExtra("username");
        i.putExtra("username", username);
        startActivity(i);
    }

    public void ratingPage(View v) {
        Intent i = new Intent(this, RatingActivity.class);
        String username = getIntent().getStringExtra("username");
        i.putExtra("username", username);
        startActivity(i);
    }
}