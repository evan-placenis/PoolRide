package controllers;

import android.util.Log;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.javapoolrides.Databases.Customer.Customer;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;
import com.example.javapoolrides.Databases.Driver.Driver;
import com.example.javapoolrides.Databases.Driver.DriverDatabase;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.List;

public class DatabaseController  extends AppCompatActivity {
    //Registration
    public boolean userAlreadyExists(String username, CustomerDatabase db){
        encryptionController E = new encryptionController();
        int key = E.getKey();
        username = E.decrypt(username, key);
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
        username = E.decrypt(username, key);
        password = E.decrypt(password, key);
        email = E.decrypt(email, key);
        phone = E.decrypt(phone, key);
        firstName = E.decrypt(firstName, key);
        lastName = E.decrypt(lastName, key);

        Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");
        Pattern phonePattern = Pattern.compile("\\d{10}");

        Matcher emailMatcher = emailPattern.matcher(email);
        Matcher phoneMatcher = phonePattern.matcher(phone);
        boolean validInfo = emailMatcher.find() && phoneMatcher.find();

        validInfo = validInfo && username.length() > 0 && password.length() > 0 &&
                firstName.length() > 0 && lastName.length() > 0;
        // (email.contains("@") && email.contains(".") && phone.length() == 10);

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
    public boolean loginDriver(String username,String password, DriverDatabase db){
        List<Driver> customerList = db.driverDao().getAllDrivers();
        for(Driver driver: customerList){
            if (driver.username.equals(username) && driver.password.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
