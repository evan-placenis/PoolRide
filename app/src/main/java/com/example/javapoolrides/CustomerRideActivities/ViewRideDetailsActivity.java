package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.javapoolrides.R;

import org.w3c.dom.Text;

public class ViewRideDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String pickup = getIntent().getStringExtra("pickup");
        String dropoff = getIntent().getStringExtra("dropoff");
        setContentView(R.layout.activity_view_ride_details);
        setTitle("Ride details");
        TextView pickuploc = ((TextView) findViewById(R.id.pickup_tv));
        pickuploc.setText(pickup);
        TextView dropoffloc = ((TextView) findViewById(R.id.destination_tv));
        dropoffloc.setText(dropoff);
    }

    public void home(View v){
        Intent i = new Intent(this, CustomerRideActivity.class);
        String username = getIntent().getStringExtra("username");
        i.putExtra("username", username);
        startActivity(i);
    }
}