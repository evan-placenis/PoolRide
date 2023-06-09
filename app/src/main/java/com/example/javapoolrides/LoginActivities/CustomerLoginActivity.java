package com.example.javapoolrides.LoginActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.javapoolrides.CustomerHomeActivity;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;
import com.example.javapoolrides.Databases.Customer.Customer;
import com.example.javapoolrides.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import controllers.DatabaseController;

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

        //Obtain values from input fields
        String username = ((TextView) findViewById(R.id.loginName)).getText().toString();
        String password = ((TextView) findViewById(R.id.loginPassword)).getText().toString();

        DatabaseController controller = new DatabaseController();
        Boolean correctEntry = controller.loginUser(username,password, db);
        //db.clearAllTables();

        //only enter user if there is existing user
        if (correctEntry) {
            Context context = getApplicationContext();
            CharSequence text = "Successfully Login!";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
            Intent i = new Intent(this, CustomerHomeActivity.class);
            i.putExtra("username", username);
            startActivity(i);
        }else{
            //alert error message
            Context context = getApplicationContext();
            CharSequence text = "Incorrect username and password!";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
        }


    }
}