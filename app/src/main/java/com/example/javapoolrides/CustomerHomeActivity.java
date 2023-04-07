package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CustomerHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);
        setTitle("Home");
        // Intent i = getIntent();
        //passing data to another activity with PutExtra;
        // String userName = i.getStringExtra("Registration");
        // ((TextView)findViewById(R.id.output)).setText("Hello " + userName);
    }

    public void editAccount(View v){
        //launch a new activity

        Intent i = new Intent(this, EditActivity.class);
        startActivity(i);
    }
    /*
    public void handleText(View v){
        //get input from user and apply it to output
        EditText t = findViewById(R.id.source);
        String input = t.getText().toString();

        ((TextView)findViewById(R.id.output)).setText(input);

        //MAKE ALERT
        Toast.makeText(this,"ALERT", Toast.LENGTH_LONG).show();
    }
    public void disable(View v){
        /* take action on a specific button
        View myView = findViewById(R.id.button);
        myView.setEnabled(false);
        Button button = (Button) myView; //cast this myView as a button so we can call setText
        button.setText("New Disabled");
        */

        /* take action on button in the parameter
        v.setEnabled(false); //disable button from being clicked again

        Button button = (Button) v;
        button.setText("Disabled"); //setting button text to disabled once clicked

        Log.d("success", "Button Disabled");


    }
    */
}