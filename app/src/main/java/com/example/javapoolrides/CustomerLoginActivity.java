package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class CustomerLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
        setTitle("Customer Login");
    }
    public void customerHomePage(View v) {

        CustomerDatabase db = Room.databaseBuilder(getApplicationContext(),
                CustomerDatabase.class, "customer-database").allowMainThreadQueries().build();

//        Customer joe = new Customer("Joe", "Test");
//        Customer peter = new Customer("Peter", "Test2");
//
//        db.customerDao().insertAll(joe,peter);
//
//        List<Customer> customerList = db.customerDao().getAllCustomers();
//        for(Customer list: customerList){
//            Log.d("customers", list.username + " " + list.password);
//        }
        String username = ((TextView)findViewById(R.id.customerLoginUsername)).getText().toString();
        String password = ((TextView)findViewById(R.id.customerLoginPassword)).getText().toString();

        Customer customer = new Customer(username, password);
        db.customerDao().insertAll(customer);

        Intent i = new Intent(this,CustomerHomeActivity.class);
        startActivity(i);
    }
}