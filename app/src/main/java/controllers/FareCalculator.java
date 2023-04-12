package controllers;

import java.util.Random;

public class FareCalculator {

    public float calculateFare(){
        Random r = new Random();
        float fare = 10 + r.nextFloat() * (30 - 10);
        return fare;
    }

}
