package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OfferRideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_ride);
        setTitle("Offer Ride");
    }
    public void qrCode(View v){
        //launch a new activity

        Intent i = new Intent(this, QRCodeActivity.class);
        startActivity(i);
    }
}