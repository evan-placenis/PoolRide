package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.javapoolrides.CustomerHomeActivity;
import com.example.javapoolrides.Databases.Order.Order;
import com.example.javapoolrides.Databases.Order.OrderDao;
import com.example.javapoolrides.Databases.Order.OrderDatabase;
import com.example.javapoolrides.R;

import java.util.List;

import controllers.DatabaseController;

public class ViewRidesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rides);
        setTitle("Choose your ride");

        //Make the buttons display the names created on the previouse page, if the name is none turn the button off
        Button firstButton = findViewById(R.id.firstChoice);
        String firstChoice = getIntent().getStringExtra("firstChoice");
        firstButton.setText(firstChoice);
        if(firstChoice.equals("None")){
            firstButton.setEnabled(false);
        }

        Button secondButton = findViewById(R.id.secondChoice);
        String secondChoice = getIntent().getStringExtra("secondChoice");
        secondButton.setText(secondChoice);
        if(secondChoice.equals("None")){
            secondButton.setEnabled(false);
        }

        Button thirdButton = findViewById(R.id.thirdChoice);
        String thirdChoice = getIntent().getStringExtra("thirdChoice");
        thirdButton.setText(thirdChoice);
        if(thirdChoice.equals("None")){
            thirdButton.setEnabled(false);
        }

    }

    public void firstRide (View v) {
        //update number of seats in the car
        OrderDatabase dbO = Room.databaseBuilder(getApplicationContext(),
                OrderDatabase.class, "order-database").allowMainThreadQueries().build();
        String driver = getIntent().getStringExtra("firstChoiceName");
        DatabaseController controller = new DatabaseController();
        controller.updateSeats(dbO,driver);
        Intent i = new Intent(this, CustomerRideActivity.class);
        String username = getIntent().getStringExtra("username");
        String pickup = getIntent().getStringExtra("pickup");
        String dropoff = getIntent().getStringExtra("dropoff");
        i.putExtra("pickup", pickup);
        i.putExtra("dropoff", dropoff);
        i.putExtra("username", username);
        startActivity(i);
    }

    public void secondRide (View v) {
        OrderDatabase dbO = Room.databaseBuilder(getApplicationContext(),
                OrderDatabase.class, "order-database").allowMainThreadQueries().build();
        String driver = getIntent().getStringExtra("secondChoiceName");
        DatabaseController controller = new DatabaseController();
        controller.updateSeats(dbO,driver);
        Intent i = new Intent(this, CustomerRideActivity.class);
        String username = getIntent().getStringExtra("username");
        String pickup = getIntent().getStringExtra("pickup");
        String dropoff = getIntent().getStringExtra("dropoff");
        i.putExtra("pickup", pickup);
        i.putExtra("dropoff", dropoff);
        i.putExtra("username", username);
        startActivity(i);
    }

    public void thirdRide (View v) {
        OrderDatabase dbO = Room.databaseBuilder(getApplicationContext(),
                OrderDatabase.class, "order-database").allowMainThreadQueries().build();
        String driver = getIntent().getStringExtra("thirdChoiceName");
        DatabaseController controller = new DatabaseController();
        controller.updateSeats(dbO,driver);
        Intent i = new Intent(this, CustomerRideActivity.class);
        String username = getIntent().getStringExtra("username");
        String pickup = getIntent().getStringExtra("pickup");
        String dropoff = getIntent().getStringExtra("dropoff");
        i.putExtra("pickup", pickup);
        i.putExtra("dropoff", dropoff);
        i.putExtra("username", username);
        startActivity(i);
    }

    public void cancelRide (View v) {
        Intent i = new Intent(this, CustomerHomeActivity.class);
        String username = getIntent().getStringExtra("username");
        i.putExtra("username", username);
        startActivity(i);
    }

}