package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javapoolrides.Databases.Customer.Customer;
import com.example.javapoolrides.Databases.Driver.Driver;
import com.example.javapoolrides.Databases.Driver.DriverDatabase;

import java.util.List;

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
        String username = "evan";
        String password = "test";
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