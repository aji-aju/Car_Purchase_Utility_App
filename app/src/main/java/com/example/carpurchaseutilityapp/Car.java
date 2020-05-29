package com.example.carpurchaseutilityapp;

public class Car {
    public String name;
    int customerId;
    int id;
    String model;
    int price;
    double resale_value;
    public Car(int customerId,int id, String model, int price) {
        this.customerId = customerId;
        this.id = id;
        this.model = model;
        this.price = price;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public double getResale_value() {
        return resale_value;
    }
}
