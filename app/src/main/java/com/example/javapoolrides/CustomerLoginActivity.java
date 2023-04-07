package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CustomerLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
        setTitle("Customer Login");
    }
    public void customerHomePage(View v){
        //launch a new activity

        Intent i = new Intent(this,CustomerHomeActivity.class);
        startActivity(i);
    }
}