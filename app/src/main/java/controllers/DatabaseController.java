package controllers;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javapoolrides.Databases.Customer.Customer;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;

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

    public boolean correctDetails(String username, String password, String email, String phone){
        //TODO
        return true;
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
