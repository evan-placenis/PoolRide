package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.javapoolrides.DriverRideActivities.AcceptRideActivity;
import com.example.javapoolrides.DriverRideActivities.RideHomeActivity;
import com.example.javapoolrides.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Timer;
import java.util.TimerTask;

public class CustomerRideActivity extends AppCompatActivity implements OnMapReadyCallback {

    Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_ride);
        setTitle("Your ride");
        //MapView mapView = findViewById(R.id.arrival);
        //mapView.onCreate(savedInstanceState);
        // simulate ride

        // Get the SupportMapFragment and request notification when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng mcmaster = new LatLng(43.26145, -79.91907);
        googleMap.addMarker(new MarkerOptions()
                .position(mcmaster)
                .title("Marker in Sydney"));
        googleMap.animateCamera( CameraUpdateFactory.newLatLngZoom(mcmaster, 16.8f ) );

    }

}