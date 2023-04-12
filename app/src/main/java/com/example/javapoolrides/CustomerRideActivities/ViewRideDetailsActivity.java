package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.javapoolrides.R;

public class ViewRideDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_ride_details);
        setTitle("Ride details");
    }

    public void home(View v){
        Intent i = new Intent(this, CustomerRideActivity.class);
        String username = getIntent().getStringExtra("username");
        i.putExtra("username", username);
        startActivity(i);
    }
}