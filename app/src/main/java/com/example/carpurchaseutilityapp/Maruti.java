package com.example.carpurchaseutilityapp;

public class Maruti extends Car{
    public Maruti(int customerId,int id, String model, int price) {
        super(customerId,id, model, price);
        name = "Maruti";
        resale_value = 0.6 * price;
    }
}
