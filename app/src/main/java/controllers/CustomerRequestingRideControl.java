package controllers;

import android.util.Log;
import android.util.Pair;

import com.example.javapoolrides.Databases.Customer.Customer;
import com.example.javapoolrides.Databases.Customer.CustomerDatabase;
import com.example.javapoolrides.Databases.Order.Order;
import com.example.javapoolrides.Databases.Order.OrderDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CustomerRequestingRideControl {
    public Map<String,Integer> findMatch(OrderDatabase dbO,CustomerDatabase dbC, Boolean petFriendly, Boolean accessibility, String username){
        //------------------------------ better
        String petF = " ";
        String access = " ";

        Random random = new Random();

        if(petFriendly == true){
            petF = "true";
        }else{
            petF = "false";
        }
        if(accessibility == true){
            access = "true";
        }else{
            access = "false";
        }
        //------------------------------------------

        //Create list of possible matches

        Map<String,Integer> matchedCars = new HashMap();
        List<Order> orderList = dbO.orderDao().getAllOrders();

        //Search for the customer in the database to obtain the questionaire results

        Customer customer = findCustomer(dbC, username);

        String q1 = customer.q1;
        String q2 = customer.q2;
        String q3 = customer.q3;


        int currWeight = 0;
        int percentage;
        int maxDist = 5;
        int randomDist;

        for(int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            if (order.seatsAvail == "0" || !(petF.equals(order.petFriendly)) || (access.equals("true") && order.accessibility.equals("false"))){
                //Log.d("ISSUE", order.accessibility+ " " + accessibility);
                continue;
            }
            if (order.q1.equals(q1)) {
                currWeight += 12;
                Log.d("WEIGHTS", String.valueOf(currWeight) + " " + order.driver);
            }
            if (order.q2.equals(q2)) {
                currWeight += 10;
                Log.d("WEIGHTS", String.valueOf(currWeight) + " " + order.driver);
            }
            if (order.q3.equals(q3)) {
                currWeight += 8;
                Log.d("WEIGHTS", String.valueOf(currWeight) + " " + order.driver);
            }

            //Add one for seats

            randomDist = random.nextInt(maxDist);
            currWeight += randomDist;
            Log.d("Final WEIGHTS", String.valueOf(currWeight) + " " + order.driver);
            percentage = Math.round((currWeight*100)/35);
            Log.d("Percentage", String.valueOf(percentage) + " " + order.driver);
            matchedCars.put(order.driver, percentage);

            currWeight = 0;
        }


        //Identify the three best options and put into new map to be returned to the user
        Map<String,Integer> topThree= new HashMap();
        for(int j = 0; j < 3; j++){
            if(matchedCars.size() > 0){
                Map.Entry<String, Integer> maxEntry = null;
                for (Map.Entry<String, Integer> entry : matchedCars.entrySet()) {
                    if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                        maxEntry = entry;
                    }
                }
                topThree.put(maxEntry.getKey(),maxEntry.getValue());
                matchedCars.remove(maxEntry.getKey());
            }
        }


        return topThree;
    }
    //Method Should be in Database Controller?
    public Customer findCustomer(CustomerDatabase dbC, String username){
        encryptionController E = new encryptionController();
        int key = E.getKey();
        List<Customer> customerList = dbC.customerDao().getAllCustomers();
        for(Customer customer: customerList){

            if (E.decrypt(customer.username,key).equals(username)){
                return customer;
            }
        }
        return null;
    }
}
