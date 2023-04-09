package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.javapoolrides.R;

public class CustomerRideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_ride);
        setTitle("Your ride");
    }

    /*public void viewMap (View v) {
        Intent i = new Intent(this, CustomerHomeActivity.class);
        startActivity(i);
    }*/

    public void viewRideDetails (View v) {
        Intent i = new Intent(this, ViewRideDetailsActivity.class);
        startActivity(i);
    }


}