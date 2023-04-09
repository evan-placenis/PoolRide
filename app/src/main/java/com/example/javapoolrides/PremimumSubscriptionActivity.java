package com.example.javapoolrides;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PremimumSubscriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premimum_subscription_page);
        setTitle("Subscription");
    }

    public void sub(View i) {
        Context context = getApplicationContext();
        CharSequence text = "Successfully Joined RidePool+";
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void home(View v){
        Intent i = new Intent(this, ViewAccountDetailsActivity.class);
        startActivity(i);
    }
}