package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("PoolRide");
        // Intent i = getIntent();
        //passing data to another activity with PutExtra;
        // String userName = i.getStringExtra("Registration");
        // ((TextView)findViewById(R.id.output)).setText("Hello " + userName);
    }

    public void customerLogin(View v){
        //launch a new activity

        Intent i = new Intent(this, CustomerLoginActivity.class);
        startActivity(i);
    }

    public void driverLogin(View v){
        //launch a new activity

        Intent i = new Intent(this, DriverLoginActivity.class);
        startActivity(i);
    }

    public void registration(View v){
        //launch a new activity

        Intent i = new Intent(this, RegistrationActivity.class);
        startActivity(i);
    }

}