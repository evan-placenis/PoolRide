package com.example.javapoolrides;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class EditAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account_page);
        update();
    }

    public void home(View v){
        Intent i = new Intent(this, ViewAccountDetailsActivity.class);
        startActivity(i);
    }

    public void submit(View v){
        //some database stuff
    }

    public void update(){
        //some database stuff
    }
}