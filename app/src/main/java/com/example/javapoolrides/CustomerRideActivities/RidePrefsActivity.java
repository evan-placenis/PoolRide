package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.javapoolrides.CustomerHomeActivity;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;
import com.example.javapoolrides.Databases.Order.OrderDatabase;
import com.example.javapoolrides.R;

public class RidePrefsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_prefs);
        setTitle("Choose ride preferences");
    }

    public void submitPrefs (View v) {
        //Get data

        OrderDatabase db = Room.databaseBuilder(getApplicationContext(),
                OrderDatabase.class, "order-database").allowMainThreadQueries().build();

        Switch shareSwitch = (Switch) findViewById(R.id.shareSwitch);
        Switch accessibilitySwitch = (Switch) findViewById(R.id.accessibilitySwitch);
        Switch petSwitch = (Switch) findViewById(R.id.petSwitch);

        boolean share = shareSwitch.isChecked();
        boolean accessibility = accessibilitySwitch.isChecked();
        boolean pet = petSwitch.isChecked();

//        if (share | accessibility | pet) {
//            Toast.makeText(RidePrefsActivity.this,
//                    "On", Toast.LENGTH_SHORT).show();
//        }

        Intent i = new Intent(this, ViewRidesActivity.class);


        startActivity(i);



    }

    public void home (View v){
        Intent i = new Intent(this, CustomerHomeActivity.class);
        startActivity(i);
    }
}