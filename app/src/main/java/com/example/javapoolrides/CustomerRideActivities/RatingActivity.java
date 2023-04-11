package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;

import com.example.javapoolrides.CustomerHomeActivity;
import com.example.javapoolrides.R;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        setTitle("Rating");
    }

    public void submit(View v) {
        RatingBar mBar = (RatingBar) findViewById(R.id.ratingBar2);
        String rating = String.valueOf(mBar.getRating());
        Intent i = new Intent(this, CustomerHomeActivity.class);
        startActivity(i);
    }
}