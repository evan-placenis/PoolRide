package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.javapoolrides.CustomerRideActivities.ArrivalActivity;
import com.example.javapoolrides.Databases.Driver.Driver;
import com.example.javapoolrides.Databases.Driver.DriverDatabase;
import com.example.javapoolrides.LoginActivities.CustomerLoginActivity;
import com.example.javapoolrides.LoginActivities.DriverLoginActivity;
import com.example.javapoolrides.RegistrationActivities.RegistrationActivity;

import controllers.encryptionController;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("PoolRide");

        //Inserting Drivers into database
        DriverDatabase db = Room.databaseBuilder(getApplicationContext(),
                DriverDatabase.class, "driver-database").allowMainThreadQueries().build();
        db.clearAllTables();

        encryptionController E = new encryptionController();
        int key = E.getKey();
        String username = E.encrypt("evan",key);
        String password = E.encrypt("test",key);
        Driver driver = new Driver(username, password);
        db.driverDao().insertAll(driver);

    }

    public void customerLogin(View v){
        Intent i = new Intent(this, CustomerLoginActivity.class);
        startActivity(i);
    }

    public void driverLogin(View v){
        Intent i = new Intent(this, DriverLoginActivity.class);
        startActivity(i);
    }

    public void registration(View v){
        Intent i = new Intent(this, RegistrationActivity.class);
        startActivity(i);
    }

    public void test(View v){
        Intent i = new Intent(this, ArrivalActivity.class);
        startActivity(i);
    }

    public void test1(View v){
        Intent i = new Intent(this, ArrivalActivity.class);
        startActivity(i);
    }
}