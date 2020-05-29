package com.example.carpurchaseutilityapp;

public class Hyundai extends Car{
    public Hyundai(int customerId,int id, String model, int price) {
        super(customerId,id, model, price);
        name = "Hyundai";
        resale_value = 0.4 * price;
    }
}
