package com.example.javapoolrides.CustomerAccountActivities;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.javapoolrides.CustomerAccountActivities.ViewAccountDetailsActivity;
import com.example.javapoolrides.Databases.Customer.Customer;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;
import com.example.javapoolrides.R;

import java.util.List;

import controllers.encryptionController;

public class PremimumSubscriptionActivity extends AppCompatActivity {
    private String sub = "false";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premimum_subscription_page);
        setTitle("Subscription");
        update();
    }

    public void sub(View i) {
        if(sub.equals("true")){
            Context context = getApplicationContext();
            CharSequence text = "Dear user, you are already a Premium member";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
        }else{
            Context context = getApplicationContext();
            CharSequence text = "Successfully Joined RidePool+";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
            String username = getIntent().getStringExtra("username");
            CustomerDatabase db = Room.databaseBuilder(getApplicationContext(),
                    CustomerDatabase.class, "customer-database").allowMainThreadQueries().build();
            encryptionController E = new encryptionController();
            int key = E.getKey();
            List<Customer> customerList = db.customerDao().getAllCustomers();
            for(Customer customer: customerList){
                if(E.decrypt(customer.username,key).equals(username)) {
                    customer.setSub("true");
                    db.customerDao().update(customer);
                    break;
                }
            }
        }
        update();
    }

    public void home(View v){
        String username = getIntent().getStringExtra("username");
        Intent i = new Intent(this, ViewAccountDetailsActivity.class);
        i.putExtra("username", username);
        startActivity(i);
    }

    public void update(){
        String username = getIntent().getStringExtra("username");
        CustomerDatabase db = Room.databaseBuilder(getApplicationContext(),
                CustomerDatabase.class, "customer-database").allowMainThreadQueries().build();
        encryptionController E = new encryptionController();
        int key = E.getKey();
        List<Customer> customerList = db.customerDao().getAllCustomers();
        for(Customer customer: customerList){
            if(E.decrypt(customer.username,key).equals(username)) {
                sub = customer.subscription;
                break;
            }
        }
        ImageView vip = (ImageView) findViewById(R.id.VIP);
        ImageView notvip = (ImageView) findViewById(R.id.NOTVIP);
        if (sub.equals("false")) {notvip.setVisibility(View.VISIBLE);vip.setVisibility(View.INVISIBLE);}
        else{notvip.setVisibility(View.INVISIBLE);vip.setVisibility(View.VISIBLE);}
    }
}