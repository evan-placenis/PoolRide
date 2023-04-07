package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ArrivalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrival);
        setTitle("Arrival");
    }

    public void returnHome(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void ratingPage(View v) {
        Intent i = new Intent(this, RatingActivity.class);
        startActivity(i);
    }
}