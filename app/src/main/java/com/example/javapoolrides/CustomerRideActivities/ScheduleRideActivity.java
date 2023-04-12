package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javapoolrides.CustomerHomeActivity;
import com.example.javapoolrides.Databases.Customer.Customer;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;
import com.example.javapoolrides.Databases.Order.Order;
import com.example.javapoolrides.Databases.ScheduledRides.Schedule;
import com.example.javapoolrides.Databases.ScheduledRides.ScheduleDatabase;
import com.example.javapoolrides.R;

import java.util.List;

import controllers.DatabaseController;

public class ScheduleRideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_ride);
        setTitle("Schedule a ride");
    }

    public void submitSchedule(View v){
        String username = getIntent().getStringExtra("username");
        Intent i = new Intent(this, CustomerHomeActivity.class);
        i.putExtra("username", username);
        String date = ((TextView) findViewById(R.id.date)).getText().toString();
        String time = ((TextView) findViewById(R.id.time)).getText().toString();
        String destinationLoc = ((TextView) findViewById(R.id.destination)).getText().toString();
        String pickupLoc = ((TextView) findViewById(R.id.pickup)).getText().toString();

        //Call in controller database
        CustomerDatabase db = Room.databaseBuilder(getApplicationContext(),
                CustomerDatabase.class, "customer-database").allowMainThreadQueries().build();

        DatabaseController controller = new DatabaseController();
        Boolean hasPremSub = controller.hasPremSub(username,db);

        if(hasPremSub){
            Schedule schedule = new Schedule(date,time,destinationLoc,pickupLoc,username);

            ScheduleDatabase dbS = Room.databaseBuilder(getApplicationContext(),
                    ScheduleDatabase.class, "schedule-database").allowMainThreadQueries().build();
            dbS.scheduleDao().insertAll(schedule);

            Context context = getApplicationContext();
            CharSequence text = "Schedule Made!";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
            startActivity(i);
        }else{
            Context context = getApplicationContext();
            CharSequence text = "Error: no premium subscription found";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}