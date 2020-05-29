package com.example.carpurchaseutilityapp;

public class Toyota extends Car{
    public Toyota(int customerId,int id, String model, int price) {
        super(customerId,id, model, price);
        name = "Toyota";
        resale_value = 0.8 * price;
    }
}
