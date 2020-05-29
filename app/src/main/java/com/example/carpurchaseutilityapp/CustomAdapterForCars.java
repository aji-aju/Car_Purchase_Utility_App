package com.example.carpurchaseutilityapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapterForCars extends ArrayAdapter<String> {
    private ArrayList<String> names;
    private ArrayList<String> models;
    private ArrayList<String> prices;
    private ArrayList<String> resale_values;
    public CustomAdapterForCars(@NonNull Context context, ArrayList<String> id,
                         ArrayList<String> name, ArrayList<String> model,
                         ArrayList<String> price, ArrayList<String> resale_value) {
        super(context,R.layout.custom_car,id);
        names = name;
        models = model;
        prices = price;
        resale_values = resale_value;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable final View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        @SuppressLint("ViewHolder") final View customView = myInflater.inflate(R.layout.custom_car,parent,false);

        String id = getItem(position);
        TextView id1 = (TextView) customView.findViewById(R.id.carIdholder);
        TextView name= (TextView) customView.findViewById(R.id.carnameholder);
        TextView model = (TextView) customView.findViewById(R.id.carmodelholder);
        TextView price = (TextView) customView.findViewById(R.id.priceholder);
        TextView resale = (TextView) customView.findViewById(R.id.resaleHolder);

        //Button carDetails = (Button) convertView.findViewById(R.id.getCarDetailsButton);

        id1.setText(id);
        name.setText(names.get(position));
        model.setText(models.get(position));
        price.setText(prices.get(position));
        resale.setText(resale_values.get(position));

        return customView;
    }

}
