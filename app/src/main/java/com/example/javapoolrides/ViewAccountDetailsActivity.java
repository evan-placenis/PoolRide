package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewAccountDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_account_details_page);
    }

    public void editProfile(View v){
        Intent i = new Intent(this, EditAccountActivity.class);
        startActivity(i);
    }

    public void sub(View v){
        Intent i = new Intent(this, PremimumSubscriptionActivity.class);
        startActivity(i);
    }
    public void deleteAccount(View v){
        Intent i = new Intent(this, DeleteAccountActivity.class);
        startActivity(i);
    }
}