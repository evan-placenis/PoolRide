package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.javapoolrides.CustomerHomeActivity;
import com.example.javapoolrides.R;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ArrivalActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrival);
        setTitle("Arrival");
//        MapView mapView = findViewById(R.id.Arrival);
//        mapView.onCreate(savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);
    }

    public void returnHome(View v) {
        Intent i = new Intent(this, CustomerHomeActivity.class);
        String username = getIntent().getStringExtra("username");
        i.putExtra("username", username);
        startActivity(i);
    }

    public void ratingPage(View v) {
        Intent i = new Intent(this, RatingActivity.class);
        String username = getIntent().getStringExtra("username");
        i.putExtra("username", username);
        startActivity(i);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng landmark = new LatLng(43.257989162119074, -79.8697699443705);
        googleMap.addMarker(new MarkerOptions()
                .position(landmark)
                .title("Marker in Deestination"));
        googleMap.animateCamera( CameraUpdateFactory.newLatLngZoom(landmark, 16.8f ) );

    }
}