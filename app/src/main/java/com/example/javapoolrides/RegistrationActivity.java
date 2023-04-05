package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Registration");
    }

    public void submitForm(View v){
        //launch a new activity

        Intent i = new Intent(this, MainActivity.class);
        //
        String message = ((EditText)findViewById(R.id.userName)).getText().toString();
        i.putExtra("Registration", message);

        startActivity(i);
    }
}