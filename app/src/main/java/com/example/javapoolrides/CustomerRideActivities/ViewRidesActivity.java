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

public class ViewRidesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rides);
        setTitle("Choose your ride");

        Button firstButton = findViewById(R.id.firstChoice);
        String firstChoice = getIntent().getStringExtra("firstChoice");
        firstButton.setText(firstChoice);

        Button secondButton = findViewById(R.id.secondChoice);
        String secondChoice = getIntent().getStringExtra("secondChoice");
        secondButton.setText(secondChoice);

        Button thirdButton = findViewById(R.id.thirdChoice);
        String thirdChoice = getIntent().getStringExtra("thirdChoice");
        thirdButton.setText(thirdChoice);

    }

    public void selectRide (View v) {

//        Intent i = new Intent(this, CustomerRideActivity.class);
//        startActivity(i);
    }

    public void firstRide (View v) {
        //update number of seats in the car
        String driver = getIntent().getStringExtra("firstChoiceName");
        updateDatabase(driver);

        Intent i = new Intent(this, CustomerRideActivity.class);
        startActivity(i);
    }

    public void secondRide (View v) {
        String driver = getIntent().getStringExtra("secondChoiceName");
        updateDatabase(driver);

        Intent i = new Intent(this, CustomerRideActivity.class);
        startActivity(i);
    }

    public void thirdRide (View v) {
        String driver = getIntent().getStringExtra("thirdChoiceName");
        updateDatabase(driver);

        Intent i = new Intent(this, CustomerRideActivity.class);
        startActivity(i);
    }

    public void cancelRide (View v) {
        Intent i = new Intent(this, CustomerHomeActivity.class);
        startActivity(i);
    }

    //PUT THIS IN CONTROLLER CLASS
    public void updateDatabase(String driver){
        OrderDatabase dbO = Room.databaseBuilder(getApplicationContext(),
                OrderDatabase.class, "order-database").allowMainThreadQueries().build();
        List<Order> orderList = dbO.orderDao().getAllOrders();
        for(Order order : orderList){
            if(order.driver == driver){
                int updatedSeats = Integer.parseInt(order.seatsAvail) - 1;
                order.seatsAvail = Integer.toString(updatedSeats);
                dbO.orderDao().update(order);
            }
        }

    }
}