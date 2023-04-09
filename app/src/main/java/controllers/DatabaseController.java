package controllers;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.javapoolrides.Databases.Customer.Customer;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.List;

public class DatabaseController  extends AppCompatActivity {
    //Registration
    public boolean userAlreadyExists(String username, CustomerDatabase db){
        List<Customer> customerList = db.customerDao().getAllCustomers();
        for(Customer customer: customerList){
            if (customer.username.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean correctDetails(String username, String password, String email, String phone, String firstName, String lastName){

        encryptionController E = new encryptionController();
        int key = E.getKey();
        E.decrypt(username, key);
        E.decrypt(password, key);
        E.decrypt(email, key);
        E.decrypt(phone, key);
        E.decrypt(firstName, key);
        E.decrypt(lastName, key);

        Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");
        Pattern phonePattern = Pattern.compile("\\d{10}");

        Matcher emailMatcher = emailPattern.matcher(email);
        Matcher phoneMatcher = phonePattern.matcher(phone);
        Log.i("TEST!", emailMatcher.find() + " " + phoneMatcher.find());
        boolean validInfo = emailMatcher.find() && phoneMatcher.find();

        Log.i("TEST!", "username: " + username);
        Log.i("TEST!", "password: " + password);
        Log.i("TEST!", "first name: " + firstName);
        Log.i("TEST!", "last name: " + lastName);

        validInfo = validInfo && username.length() > 0 && password.length() > 0 &&
                firstName.length() > 0 && lastName.length() > 0;

        return validInfo;

    }

    public boolean loginUser(String username,String password, CustomerDatabase db){
        List<Customer> customerList = db.customerDao().getAllCustomers();
        for(Customer customer: customerList){
            if (customer.username.equals(username) && customer.password.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
