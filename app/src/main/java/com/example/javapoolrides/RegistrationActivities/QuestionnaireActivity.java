package com.example.javapoolrides.RegistrationActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.example.javapoolrides.CustomerHomeActivity;
import com.example.javapoolrides.Databases.Customer.Customer;
import com.example.javapoolrides.Databases.Customer.CustomerDao;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;
import com.example.javapoolrides.Databases.Order.OrderDao;
import com.example.javapoolrides.R;

public class QuestionnaireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);
        setTitle("Questionnaire");


    }

    public void submit(View v) {
        //Receive information from registration activity
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");
        String firstName = getIntent().getStringExtra("firstName");
        String lastName = getIntent().getStringExtra("lastName");
        String subscription = getIntent().getStringExtra("sub");
        String decryptUsername = getIntent().getStringExtra("decryptUsername");

        RadioGroup ageGroup;
        RadioGroup silentGroup;
        RadioGroup tobaccoGroup;

        RadioButton ageResult;
        RadioButton silentResult;
        RadioButton tobaccoResult;

        ageGroup = (RadioGroup) findViewById(R.id.Age);
        silentGroup = (RadioGroup) findViewById(R.id.Silent);
        tobaccoGroup = (RadioGroup) findViewById(R.id.Tobacco);

        int ageId = ageGroup.getCheckedRadioButtonId();
        ageResult = (RadioButton) findViewById(ageId);

        int silentId = silentGroup.getCheckedRadioButtonId();
        silentResult = (RadioButton) findViewById(silentId);

        int tobaccoId = tobaccoGroup.getCheckedRadioButtonId();
        tobaccoResult = (RadioButton) findViewById(tobaccoId);

        String age = (String) ageResult.getText();
        String silent = (String) silentResult.getText();
        String tobacco = (String) tobaccoResult.getText();

        //Update the customer database entry for
        CustomerDatabase db = Room.databaseBuilder(getApplicationContext(),
                CustomerDatabase.class, "customer-database").allowMainThreadQueries().build();

        String rating = "none"; //encrypt the rating possibly
        String totalRating = "none";
        Customer customer = new Customer(username, password, email, phone, firstName, lastName,rating, totalRating, age, silent, tobacco, subscription);
        db.customerDao().insertAll(customer);

        Intent i = new Intent(this, CustomerHomeActivity.class);
        i.putExtra("username", decryptUsername);
        startActivity(i);
    }
}