package com.example.javapoolrides.CustomerAccountActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.javapoolrides.CustomerAccountActivities.ViewAccountDetailsActivity;
import com.example.javapoolrides.Databases.Customer.Customer;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;
import com.example.javapoolrides.MainActivity;
import com.example.javapoolrides.R;

import java.util.List;

import controllers.encryptionController;

public class DeleteAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account_page);
        setTitle("Delete Account");
    }

    public void Confirm(View v){
        String username = getIntent().getStringExtra("username");
        CustomerDatabase db = Room.databaseBuilder(getApplicationContext(),
                CustomerDatabase.class, "customer-database").allowMainThreadQueries().build();
        encryptionController E = new encryptionController();
        int key = E.getKey();
        List<Customer> customerList = db.customerDao().getAllCustomers();
        for(Customer customer: customerList){
            if(E.decrypt(customer.username,key).equals(username)) {
                db.customerDao().delete(customer);
                break;
            }
        }
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void Cancel(View v) {
        String username = getIntent().getStringExtra("username");
        Intent i = new Intent(this, ViewAccountDetailsActivity.class);
        i.putExtra("username", username);
        startActivity(i);
    }
}