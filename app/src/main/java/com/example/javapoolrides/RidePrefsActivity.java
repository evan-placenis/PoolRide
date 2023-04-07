package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RidePrefsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_prefs);
        setTitle("Choose ride preferences");
    }

    public void submitPrefs (View v) {
        Intent i = new Intent(this, ViewRidesActivity.class);
        startActivity(i);
    }
}