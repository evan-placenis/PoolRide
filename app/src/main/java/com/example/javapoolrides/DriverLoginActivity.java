package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DriverLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);
        setTitle("Driver Login");
    }
    public void driverHomePage(View v){
        //launch a new activity

        Intent i = new Intent(this, DriverHomeActivity.class);
        startActivity(i);
    }
}