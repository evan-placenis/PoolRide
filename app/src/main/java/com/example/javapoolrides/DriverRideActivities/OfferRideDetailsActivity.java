package com.example.javapoolrides.DriverRideActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.example.javapoolrides.Databases.Order.Order;
import com.example.javapoolrides.Databases.Order.OrderDatabase;
import com.example.javapoolrides.R;

import java.util.List;

public class OfferRideDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_ride_details);
        setTitle("Offer Ride");
    }

    public void OfferRide(View v){

        Switch accessibilitySwitch = (Switch) findViewById(R.id.accesDriverSwitch);
        Switch petSwitch = (Switch) findViewById(R.id.petFriendlyDriverSwitch);
        boolean accessibilityBool = accessibilitySwitch.isChecked();
        boolean petFriendlyBool = petSwitch.isChecked();
        String seats = ((TextView) findViewById(R.id.seats)).getText().toString();
        Intent i = new Intent(this, QRCodeActivity.class);

        String driver = getIntent().getStringExtra("username");//Obtain the name of the user in the session
        String seatsAvail = seats;

        //Convert to string before submitting into database
        String accessibility = String.valueOf(accessibilityBool);
        String petFriendly = String.valueOf(petFriendlyBool);

        //Send driver details to QR code page
        i.putExtra("driver", driver);
        i.putExtra("seatsAvail",seatsAvail);
        i.putExtra("accessibility",accessibility);
        i.putExtra("petFriendly",petFriendly);

        startActivity(i);
    }
}