package controllers;

import android.util.Log;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.javapoolrides.Databases.Customer.Customer;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;
import com.example.javapoolrides.Databases.Driver.Driver;
import com.example.javapoolrides.Databases.Driver.DriverDatabase;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;
import com.example.javapoolrides.Databases.Order.Order;
import com.example.javapoolrides.Databases.Order.OrderDatabase;;
import java.util.ArrayList;
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

        return validInfo;

    }

    public boolean loginUser(String username,String password, CustomerDatabase db){
        encryptionController E = new encryptionController();
        int key = E.getKey();
        List<Customer> customerList = db.customerDao().getAllCustomers();
        for(Customer customer: customerList){

            if (E.decrypt(customer.username,key).equals(username) && E.decrypt(customer.password,key).equals(password)){
                return true;
            }
        }
        return false;
    }
    public boolean loginDriver(String username,String password, DriverDatabase db){
        encryptionController E = new encryptionController();
        int key = E.getKey();
        List<Driver> driverList = db.driverDao().getAllDrivers();
        for(Driver driver: driverList){
            if (E.decrypt(driver.username,key).equals(username) && E.decrypt(driver.password,key).equals(password)) {
            //if (driver.username.equals(username) && driver.password.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPremSub(String username, CustomerDatabase db){
        encryptionController E = new encryptionController();
        int key = E.getKey();
        List<Customer> customerList = db.customerDao().getAllCustomers();
        for(Customer customer: customerList){
            if(E.decrypt(customer.username,key).equals(username) && customer.subscription.equals("true")) {
                return true;
            }
        }
        return false;
    }
    public void updateSeats(OrderDatabase dbO, String driver){
        List<Order> orderList = dbO.orderDao().getAllOrders();
        for(Order order : orderList){
            if(order.driver.equals(driver)){
                int seats = Integer.parseInt(order.seatsAvail) - 1;
                Log.d("SEATS", String.valueOf(seats));
                dbO.orderDao().update(String.valueOf(seats), order.uid);
            }
        }
    }
}
