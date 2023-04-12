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
        String username = E.encrypt("jung",key);
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
            String driver = "Joe";
            String seats = "3";
            String location = "Main St";
            String petFriendly = "true";
            String accessibility = "false";
            String q1 = "No";
            String q2 ="No";
            String q3 = "Yes";
            Order order1 = new Order(driver, seats,location, petFriendly,accessibility,q1,q2,q3);

            String driverPeter = "Peter";
            String seatsPeter = "2";
            String locationPeter = "Broadway St";
            String petFriendlyPeter = "false";
            String accessibilityPeter = "true";
            String qu1 = "No";
            String qu2 ="Yes";
            String qu3 = "Yes";
            Order order2 = new Order(driverPeter, seatsPeter,locationPeter, petFriendlyPeter,accessibilityPeter,qu1,qu2,qu3);

            String driverJoe = "John";
            String seatsJoe = "5";
            String locationJoe = "Main St";
            String petFriendlyJoe = "false";
            String accessibilityJoe = "false";
            String que1 = "Yes";
            String que2 ="Yes";
            String que3 = "No";
            Order order3 = new Order(driverJoe, seatsJoe,locationJoe, petFriendlyJoe,accessibilityJoe,que1,que2,que3);

            String driverKaylan = "Kaylan";
            String seatsKaylan = "5";
            String locationKaylan = "Main St";
            String petFriendlyKaylan = "True";
            String accessibilityKaylan = "True";
            String ques1 = "Yes";
            String ques2 ="Yes";
            String ques3 = "Yes";
            Order order4 = new Order(driverKaylan, seatsKaylan,locationKaylan, petFriendlyKaylan,accessibilityKaylan,ques1,ques2,ques3);


            dbO.orderDao().insertAll(order1,order2,order3,order4);
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
}