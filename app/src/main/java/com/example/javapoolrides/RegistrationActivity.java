package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import controllers.DatabaseController;


public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Registration");
    }

    public void submitForm(View v) {

        CustomerDatabase db = Room.databaseBuilder(getApplicationContext(),
                CustomerDatabase.class, "customer-database").allowMainThreadQueries().build();

        //Obtain values from input fields
        String username = ((TextView) findViewById(R.id.userName)).getText().toString();
        String password = ((TextView) findViewById(R.id.password)).getText().toString();
        String email = ((TextView) findViewById(R.id.email)).getText().toString();
        String phone = ((TextView) findViewById(R.id.phone)).getText().toString();

        DatabaseController controller = new DatabaseController();
        Boolean correctEntry = controller.correctDetails(username, password, email, phone);

        if(!correctEntry){
            //alert error message
        }

        Boolean alreadyExists = controller.userAlreadyExists(username, db);

        //only create user if there is no existing user
        if (!alreadyExists) {
            Customer customer = new Customer(username, password, email, phone);
            db.customerDao().insertAll(customer);
        }else{
            //alert error message
        }
        Intent i = new Intent(this, QuestionnaireActivity.class);
        startActivity(i);

    }
}