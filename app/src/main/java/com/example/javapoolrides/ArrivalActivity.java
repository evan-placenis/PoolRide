package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.MapView;

public class ArrivalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrival);
        setTitle("Arrival");
        //Need API to work
        //MapView mapView = findViewById(R.id.Arrival);
        //mapView.onCreate(savedInstanceState);
    }

    public void returnHome(View v) {
        Intent i = new Intent(this, CustomerHomeActivity.class);
        startActivity(i);
    }

    public void ratingPage(View v) {
        Intent i = new Intent(this, RatingActivity.class);
        startActivity(i);
    }
}