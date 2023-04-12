package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.javapoolrides.DriverRideActivities.AcceptRideActivity;
import com.example.javapoolrides.DriverRideActivities.RideHomeActivity;
import com.example.javapoolrides.R;
import com.google.android.gms.maps.MapView;

import java.util.Timer;
import java.util.TimerTask;

public class CustomerRideActivity extends AppCompatActivity {

    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_ride);
        setTitle("Your ride");
        MapView mapView = findViewById(R.id.arrival);
        mapView.onCreate(savedInstanceState);
        // simulate ride
        timer.schedule(new TimerTask(){
            @Override
            public void run(){
                Intent i = new Intent(CustomerRideActivity.this, ArrivalActivity.class);
                String username = getIntent().getStringExtra("username");
                String pickup = getIntent().getStringExtra("pickup");
                String dropoff = getIntent().getStringExtra("dropoff");
                i.putExtra("pickup", pickup);
                i.putExtra("dropoff", dropoff);
                i.putExtra("username", username);
                startActivity(i);
                finish();
            }
        },10000);

    }

    /*public void viewMap (View v) {
        Intent i = new Intent(this, CustomerHomeActivity.class);
        startActivity(i);
    }*/

    public void viewRideDetails (View v) {
        Intent i = new Intent(this, ViewRideDetailsActivity.class);
        timer.cancel();
        timer.purge();
        String username = getIntent().getStringExtra("username");
        String pickup = getIntent().getStringExtra("pickup");
        String dropoff = getIntent().getStringExtra("dropoff");
        i.putExtra("pickup", pickup);
        i.putExtra("dropoff", dropoff);
        i.putExtra("username", username);
        startActivity(i);
    }
}