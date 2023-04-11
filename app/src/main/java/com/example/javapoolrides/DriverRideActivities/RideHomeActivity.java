package com.example.javapoolrides.DriverRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.javapoolrides.DriverHomeActivity;
import com.example.javapoolrides.R;

import java.util.Timer;
import java.util.TimerTask;

public class RideHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_home);
        setTitle("Ride Home");
        String from = getIntent().getStringExtra("from");
        if(from.equals("QR")){
            Timer timer = new Timer();
            timer.schedule(new TimerTask(){
                @Override
                public void run(){
                    Intent i = new Intent(RideHomeActivity.this, AcceptRideActivity.class);
                    startActivity(i);
                    finish();
                }
            },5000);
        }else{
            Timer timer = new Timer();
            timer.schedule(new TimerTask(){
                @Override
                public void run(){
                    Intent i = new Intent(RideHomeActivity.this, DriverDestinationActivity.class);
                    startActivity(i);
                    finish();
                }
            },5000);
        }



    }
    public void endOffer(View v){
        //ADD LOGIC TO DELETE USER FROM ORDER DATABASE

        Intent i = new Intent(this, DriverHomeActivity.class);
        startActivity(i);

    }
}