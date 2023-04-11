package com.example.javapoolrides;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.javapoolrides.CustomerRideActivities.ArrivalActivity;
import com.example.javapoolrides.Databases.Customer.Customer;
import com.example.javapoolrides.Databases.Driver.Driver;
import com.example.javapoolrides.Databases.Driver.DriverDatabase;
import com.example.javapoolrides.Databases.Order.Order;
import com.example.javapoolrides.Databases.Order.OrderDatabase;
import com.example.javapoolrides.LoginActivities.CustomerLoginActivity;
import com.example.javapoolrides.LoginActivities.DriverLoginActivity;
import com.example.javapoolrides.RegistrationActivities.RegistrationActivity;

import java.util.List;

import controllers.encryptionController;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Pool Party");

        //Inserting Drivers into database
        DriverDatabase db = Room.databaseBuilder(getApplicationContext(),
                DriverDatabase.class, "driver-database").allowMainThreadQueries().build();
        //db.clearAllTables();
        List<Driver> driverList = db.driverDao().getAllDrivers();
        if(driverList.size() == 0){
        encryptionController E = new encryptionController();
        int key = E.getKey();
        String username = E.encrypt("evan",key);
        String password = E.encrypt("test",key);
        Driver driver = new Driver(username, password);
        db.driverDao().insertAll(driver);
        }

        //Insterting Cars into the database
        OrderDatabase dbO = Room.databaseBuilder(getApplicationContext(),
                OrderDatabase.class, "order-database").allowMainThreadQueries().build();
        List<Order> orderList = dbO.orderDao().getAllOrders();
        //dbO.clearAllTables();
        if(orderList.size() == 0){
            String driv = "John";
            String seats = "5";
            String location = "test";
            String petFriendly = "false";
            String accessibility = "false";
            String q1 = "No";
            String q2 ="No";
            String q3 = "Yes";
            Order order1 = new Order(driv, seats,location, petFriendly,accessibility,q1,q2,q3);

            String drivv = "peter";
            String seatss = "2";
            String locationn = "test";
            String petFriendlyy = "false";
            String accessibilityy = "false";
            String qu1 = "No";
            String qu2 ="Yes";
            String qu3 = "Yes";
            Order order2 = new Order(drivv, seatss,locationn, petFriendlyy,accessibilityy,qu1,qu2,qu3);

            String drivvv = "Joe";
            String seatsss = "5";
            String locationnn = "test";
            String petFriendlyyy = "false";
            String accessibilityyy = "false";
            String que1 = "Yes";
            String que2 ="Yes";
            String que3 = "No";
            Order order3 = new Order(drivvv, seatsss,locationnn, petFriendlyyy,accessibilityyy,que1,que2,que3);
            dbO.orderDao().insertAll(order1,order2,order3);
        }

    }

    public void customerLogin(View v){
        Intent i = new Intent(this, CustomerLoginActivity.class);
        startActivity(i);
    }

    public void driverLogin(View v){
        Intent i = new Intent(this, DriverLoginActivity.class);
        startActivity(i);
    }

    public void registration(View v){
        Intent i = new Intent(this, RegistrationActivity.class);
        startActivity(i);
    }

    public void test(View v){
        Intent i = new Intent(this, ArrivalActivity.class);
        startActivity(i);
    }

    public void test1(View v){
        Intent i = new Intent(this, ArrivalActivity.class);
        startActivity(i);
    }
}