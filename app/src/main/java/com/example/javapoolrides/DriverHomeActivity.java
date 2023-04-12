package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.javapoolrides.DriverRideActivities.OfferRideDetailsActivity;
import com.example.javapoolrides.DriverRideActivities.QRCodeActivity;
import com.google.android.gms.maps.MapView;

public class DriverHomeActivity extends AppCompatActivity {
    private Boolean Offering = Boolean.FALSE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_home);
        setTitle("Home");
        MapView mapView = findViewById(R.id.Current);
        mapView.onCreate(savedInstanceState);

    }

    public void offerRide(View v){
        String username = getIntent().getStringExtra("username");
        Intent i = new Intent(this, OfferRideDetailsActivity.class);
        i.putExtra("username", username);
        startActivity(i);
        Offering = Boolean.TRUE;
        Context context = getApplicationContext();
        CharSequence text = "Ride Offer Started!";
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void cancelOffer(View v){
        Offering = Boolean.FALSE;
        Context context = getApplicationContext();
        CharSequence text = "Ride Offer Stopped!";
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void home(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}