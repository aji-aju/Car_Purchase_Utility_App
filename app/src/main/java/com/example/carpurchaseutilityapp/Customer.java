package com.example.carpurchaseutilityapp;

import java.util.ArrayList;

public class Customer {
    private int id;
    private String name;
    private ArrayList<Car> purchasedCars = new ArrayList<>();
    public int getId() {
        return id;
    }

    public Customer(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCar(Car car)
    {
        purchasedCars.add(car);
    }
}
