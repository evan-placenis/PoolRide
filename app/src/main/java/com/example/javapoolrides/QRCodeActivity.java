package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QRCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        setTitle("QR Code");
    }

    public void rideHomePage(View v){
        //launch a new activity

        Intent i = new Intent(this, RideHomeActivity.class);
        startActivity(i);
    }
}