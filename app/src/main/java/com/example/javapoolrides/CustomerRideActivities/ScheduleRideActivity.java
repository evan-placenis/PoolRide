package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.javapoolrides.CustomerHomeActivity;
import com.example.javapoolrides.R;

public class ScheduleRideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_ride);
        setTitle("Schedule a ride");
    }

    public void submitSchedule(View v){
        String username = getIntent().getStringExtra("username");
        Intent i = new Intent(this, CustomerHomeActivity.class);
        i.putExtra("username", username);
        startActivity(i);
    }

}