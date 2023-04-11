package com.example.javapoolrides.CustomerAccountActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javapoolrides.CustomerHomeActivity;
import com.example.javapoolrides.R;

public class ViewAccountDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_account_details_page);
        setTitle("View Account Detail");
    }

    public void editProfile(View v){
        String username = getIntent().getStringExtra("username");
        Intent i = new Intent(this, EditAccountActivity.class);
        i.putExtra("username", username);

        startActivity(i);
    }

    public void home(View v){
        String username = getIntent().getStringExtra("username");
        Intent i = new Intent(this, CustomerHomeActivity.class);
        i.putExtra("username", username);

        startActivity(i);
    }
    public void sub(View v){
        String username = getIntent().getStringExtra("username");
        Intent i = new Intent(this, PremimumSubscriptionActivity.class);
        i.putExtra("username", username);

        startActivity(i);
    }
    public void deleteAccount(View v){
        Intent i = new Intent(this, DeleteAccountActivity.class);
        startActivity(i);
    }
}