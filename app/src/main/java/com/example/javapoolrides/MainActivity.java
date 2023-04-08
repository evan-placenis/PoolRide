package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import controllers.encryptionController;

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


        CustomerDatabase db = Room.databaseBuilder(getApplicationContext(),
                CustomerDatabase.class, "customer-database").allowMainThreadQueries().build();
        Customer joe = new Customer("Joe", "Test");
        Customer peter = new Customer("Peter", "Test2");

        db.customerDao().insertAll(joe,peter);

        List<Customer> customerList = db.customerDao().getAllCustomers();

        for(Customer list: customerList){
            Log.d("customers", list.firstName + " " + list.lastName);
        }
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