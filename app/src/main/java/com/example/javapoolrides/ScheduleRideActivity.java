package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ScheduleRideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_ride);
        setTitle("Schedule a ride");
    }

    public void submitSchedule(View v){
        Intent i = new Intent(this,CustomerHomeActivity.class);
        startActivity(i);
    }

}