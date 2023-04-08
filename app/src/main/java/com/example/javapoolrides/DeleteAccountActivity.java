package com.example.javapoolrides;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account_page);
    }

    public void Confirm(View v){
        //database stuff
        Intent i = new Intent(this, ViewAccountDetailsActivity.class);
        startActivity(i);
    }

    public void Cancel(View v) {
        Intent i = new Intent(this, ViewAccountDetailsActivity.class);
        startActivity(i);
    }
}