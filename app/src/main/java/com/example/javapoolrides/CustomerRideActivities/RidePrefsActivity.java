package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.Button;

import com.example.javapoolrides.CustomerHomeActivity;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;
import com.example.javapoolrides.Databases.Order.OrderDatabase;
import com.example.javapoolrides.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import controllers.CustomerRequestingRideControl;

public class RidePrefsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_prefs);
        setTitle("Choose ride preferences");
    }

    public void submitPrefs (View v) {
        OrderDatabase dbO = Room.databaseBuilder(getApplicationContext(),
                OrderDatabase.class, "order-database").allowMainThreadQueries().build();

        CustomerDatabase dbC = Room.databaseBuilder(getApplicationContext(),
                CustomerDatabase.class, "customer-database").allowMainThreadQueries().build();

        String username = getIntent().getStringExtra("username");//Obtain the name of the user in the session

        //Obtain Data From Page
        Switch shareSwitch = (Switch) findViewById(R.id.shareSwitch);
        Switch accessibilitySwitch = (Switch) findViewById(R.id.accessibilitySwitch);
        Switch petSwitch = (Switch) findViewById(R.id.petSwitch);

        boolean share = shareSwitch.isChecked();
        boolean accessibility = accessibilitySwitch.isChecked();
        boolean pet = petSwitch.isChecked();
        //Add another to ask how many people are joining?

        //data to control class to get the top three drivers for the user
        CustomerRequestingRideControl reqRide = new CustomerRequestingRideControl();
        Map<String,Integer> topThree = reqRide.findMatch(dbO,dbC,pet,accessibility, username);

        //Send the names of the top three drivers and their score to the next page to be displayed
        Intent i = new Intent(this, ViewRidesActivity.class);
        int count = 1;
        for (Map.Entry<String, Integer> entry : topThree.entrySet()) {
            Log.d("TOP THREE",entry.getKey() + entry.getValue().toString());
            if (count == 1){
                i.putExtra("firstChoice", entry.getKey() + " " +entry.getValue().toString() + "%");
                i.putExtra("firstChoiceName", entry.getKey());//Send the drivers name alone
            }else if(count == 2){
                i.putExtra("secondChoice", entry.getKey() + " " +entry.getValue().toString()+ "%");
                i.putExtra("secondChoiceName", entry.getKey());//Send the drivers name alone
            }else if (count == 3){
                i.putExtra("thirdChoice", entry.getKey() + " " +entry.getValue().toString()+ "%");
                i.putExtra("ThirdChoiceName", entry.getKey());//Send the drivers name alone
            }
            count += 1;
        }
        //If there are less than three buttons
        while (count < 4){
            if(count == 1){
                Context context = getApplicationContext();
                CharSequence text = "No available cars with current preferences, please try again later or change preferences";
                Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                toast.show();
                i.putExtra("firstChoice", "None");
            }else if (count == 2){
                i.putExtra("secondChoice", "None");
            } else if (count == 3){
                i.putExtra("thirdChoice", "None");
            }
            count += 1;
        }
        startActivity(i);
    }

    public void home (View v){
        Intent i = new Intent(this, CustomerHomeActivity.class);
        startActivity(i);
    }
}