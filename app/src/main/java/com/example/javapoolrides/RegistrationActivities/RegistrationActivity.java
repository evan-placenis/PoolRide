package com.example.javapoolrides.RegistrationActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import com.example.javapoolrides.Databases.Customer.Customer;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;
import com.example.javapoolrides.R;
import com.example.javapoolrides.RegistrationActivities.QuestionnaireActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import controllers.DatabaseController;
import controllers.encryptionController;


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

        encryptionController E = new encryptionController();
        DatabaseController controller = new DatabaseController();

        //Obtain values from input fields
        String username = ((TextView) findViewById(R.id.userName)).getText().toString();
        String password = ((TextView) findViewById(R.id.password)).getText().toString();
        String email = ((TextView) findViewById(R.id.email)).getText().toString();
        String phone = ((TextView) findViewById(R.id.phone)).getText().toString();
        String firstName = ((TextView) findViewById(R.id.registerFirstName)).getText().toString();
        String lastName = ((TextView) findViewById(R.id.registerLastName)).getText().toString();
        Switch premSub = (Switch) findViewById(R.id.subSwitch);

        boolean premSubBool = premSub.isChecked();
        String subscription = "";
        if(premSubBool == true){
            subscription = "true";
        }else{
            subscription = "false";
        }


        //encrypt messages before passing
        int key = E.getKey();
        username = E.encrypt(username, key);
        password = E.encrypt(password, key);
        email = E.encrypt(email, key);
        phone = E.encrypt(phone, key);
        firstName = E.encrypt(firstName, key);
        lastName = E.encrypt(lastName, key);

        Boolean correctEntry = controller.correctDetails(username, password, email, phone, firstName, lastName);

        if(!correctEntry){
            Context context = getApplicationContext();
            CharSequence text = "Invalid credentials";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        Boolean alreadyExists = controller.userAlreadyExists(username, db);

        //only create user if there is no existing user
        if (!alreadyExists) {
            Intent i = new Intent(this, QuestionnaireActivity.class);
            i.putExtra("username", username);
            i.putExtra("password", password);
            i.putExtra("email", email);
            i.putExtra("phone", phone);
            i.putExtra("firstName", firstName);
            i.putExtra("lastName", lastName);
            i.putExtra("sub", subscription);
            i.putExtra("decryptUsername", E.decrypt(username,key));
            startActivity(i);
        }else{
            Context context = getApplicationContext();
            CharSequence text = "User already exists, try a new username!";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}