package com.example.javapoolrides.LoginActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javapoolrides.Databases.Customer.CustomerDatabase;
import com.example.javapoolrides.Databases.Driver.DriverDatabase;
import com.example.javapoolrides.DriverHomeActivity;
import com.example.javapoolrides.R;

import controllers.DatabaseController;

public class DriverLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_login);
        setTitle("Driver Login");
    }
    public void driverHomePage(View v){
        DriverDatabase db = Room.databaseBuilder(getApplicationContext(),
                DriverDatabase.class, "driver-database").allowMainThreadQueries().build();

        String username = ((TextView) findViewById(R.id.DriverUsername)).getText().toString();
        String password = ((TextView) findViewById(R.id.DriverLoginPassword)).getText().toString();

        DatabaseController controller = new DatabaseController();
        Boolean correctEntry = controller.loginDriver(username,password, db);

        if (correctEntry) {
            Intent i = new Intent(this, DriverHomeActivity.class);
            i.putExtra("username", username);
            startActivity(i);
            Context context = getApplicationContext();
            CharSequence text = "Successfully Login!";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
        }else{
            //alert error message
            Context context = getApplicationContext();
            CharSequence text = "Incorrect username and password!";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}