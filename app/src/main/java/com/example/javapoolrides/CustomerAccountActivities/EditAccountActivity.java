package com.example.javapoolrides.CustomerAccountActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.javapoolrides.Databases.Customer.Customer;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;
import com.example.javapoolrides.R;

import java.util.List;

import controllers.encryptionController;

public class EditAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account_page);
        setTitle("EditAccount");
        update();
    }

    public void home(View v){
        String username = getIntent().getStringExtra("username");
        Intent i = new Intent(this, ViewAccountDetailsActivity.class);
        i.putExtra("username", username);
        startActivity(i);
    }

    public void submit(View v){
        String username = ((EditText) findViewById(R.id.username_tf)).getText().toString();
        String email = ((EditText) findViewById(R.id.email_tf)).getText().toString();
        String firstName = ((EditText) findViewById(R.id.firstname_tf)).getText().toString();
        String lastName = ((EditText) findViewById(R.id.lastname_tf)).getText().toString();
        String phone = ((EditText) findViewById(R.id.phonenumber_tf)).getText().toString();

        CustomerDatabase db = Room.databaseBuilder(getApplicationContext(),
                CustomerDatabase.class, "customer-database").allowMainThreadQueries().build();
        encryptionController E = new encryptionController();
        int key = E.getKey();
        List<Customer> customerList = db.customerDao().getAllCustomers();
        for(Customer customer: customerList){
            if(E.decrypt(customer.username,key).equals(username)) {
                customer.setUsername(E.encrypt(username,key));
                customer.setEmail(E.encrypt(email,key));
                customer.setFirstName(E.encrypt(firstName,key));
                customer.setLastName(E.encrypt(lastName,key));
                customer.setPhone(E.encrypt(phone,key));
                db.customerDao().update(customer);
                break;
            }
        }
    }

    public void update(){
        String username = getIntent().getStringExtra("username");
        String email = "", firstname = "", lastname = "", phone = "";
        CustomerDatabase db = Room.databaseBuilder(getApplicationContext(),
                CustomerDatabase.class, "customer-database").allowMainThreadQueries().build();
        encryptionController E = new encryptionController();
        int key = E.getKey();
        List<Customer> customerList = db.customerDao().getAllCustomers();
        for(Customer customer: customerList){
            if(E.decrypt(customer.username,key).equals(username)) {
                email = E.decrypt(customer.email,key);
                firstname = E.decrypt(customer.firstName,key);
                lastname = E.decrypt(customer.lastName,key);
                phone = E.decrypt(customer.phone,key);
                break;
            }
        }
        EditText fn = (EditText) findViewById(R.id.firstname_tf);
        EditText ln = (EditText) findViewById(R.id.lastname_tf);
        EditText em = (EditText) findViewById(R.id.email_tf);
        EditText ph = (EditText) findViewById(R.id.phonenumber_tf);
        EditText user = (EditText) findViewById(R.id.username_tf);
        fn.setText(firstname);
        ln.setText(lastname);
        em.setText(email);
        ph.setText(phone);
        user.setText(username);
    }
}