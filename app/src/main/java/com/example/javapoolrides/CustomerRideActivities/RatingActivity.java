package com.example.javapoolrides.CustomerRideActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;

import com.example.javapoolrides.CustomerHomeActivity;
import com.example.javapoolrides.Databases.Customer.Customer;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;
import com.example.javapoolrides.Databases.Order.Order;
import com.example.javapoolrides.R;

import java.util.List;

import controllers.encryptionController;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        setTitle("Rating");
    }

    public void submit(View v) {
        RatingBar mBar = (RatingBar) findViewById(R.id.ratingBar2);
        String rating = String.valueOf(mBar.getRating());
        String username = getIntent().getStringExtra("username");

        CustomerDatabase db = Room.databaseBuilder(getApplicationContext(),
                CustomerDatabase.class, "customer-database").allowMainThreadQueries().build();
        encryptionController E = new encryptionController();
        int key = E.getKey();

        List<Customer> customerList = db.customerDao().getAllCustomers();

        for(Customer customer: customerList){
            if((E.decrypt(customer.username,key).equals(username))){
                if(customer.rating.equals("none")){
                    customer.updateRating(rating);
                    customer.updateTotalRating("1");
                    db.customerDao().update(customer);
                }else{
                    int denominator = Integer.parseInt(customer.totalRating) + 1;
                    float numerator = Float.parseFloat(customer.rating) + Float.parseFloat(rating);
                    float newRating = numerator/denominator;
                    customer.updateRating(String.valueOf(newRating));
                    customer.updateTotalRating(String.valueOf(denominator));
                    db.customerDao().update(customer);
                }
                break;
            }
        }

        Intent i = new Intent(this, CustomerHomeActivity.class);
        i.putExtra("username", username);
        startActivity(i);
    }
}