package com.example.javapoolrides.DriverRideActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.javapoolrides.Databases.Order.Order;
import com.example.javapoolrides.Databases.Order.OrderDatabase;
import com.example.javapoolrides.DriverHomeActivity;
import com.example.javapoolrides.R;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class RideHomeActivity extends AppCompatActivity {
    Timer timer = new Timer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride_home);
        setTitle("Ride Home");
        String from = getIntent().getStringExtra("from");
        if(from.equals("QR")){
            timer.schedule(new TimerTask(){
                @Override
                public void run(){
                    Intent i = new Intent(RideHomeActivity.this, AcceptRideActivity.class);
                    startActivity(i);
                    finish();
                }
            },10000);
        }else{
            timer.schedule(new TimerTask(){
                @Override
                public void run(){
                    Intent i = new Intent(RideHomeActivity.this, DriverDestinationActivity.class);
                    startActivity(i);
                    finish();
                }
            },5000);
        }



    }
    public void endOffer(View v){
        OrderDatabase db = Room.databaseBuilder(getApplicationContext(),
                OrderDatabase.class, "order-database").allowMainThreadQueries().build();
        String driverName = getIntent().getStringExtra("driver");
        List<Order> orderList = db.orderDao().getAllOrders();
        for(Order order: orderList){
            if(order.driver.equals(driverName)){
                db.orderDao().delete(order);
            }
        }
        Intent i = new Intent(this, DriverHomeActivity.class);
        timer.cancel();
        timer.purge();
        startActivity(i);


    }
}