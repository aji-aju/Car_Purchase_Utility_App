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

class CustomAdapter extends ArrayAdapter<String> {
    private ArrayList<String> names;
    public CustomAdapter(@NonNull Context context, ArrayList<String> id, ArrayList<String> name) {
        super(context, R.layout.custom_row,id);
        names = name;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable final View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        @SuppressLint("ViewHolder") final View customView = myInflater.inflate(R.layout.custom_row,parent,false);

        String id = getItem(position);
        TextView id1 = (TextView) customView.findViewById(R.id.customerIdHolder);
        TextView name= (TextView) customView.findViewById(R.id.customerNameHolder);
        //Button carDetails = (Button) convertView.findViewById(R.id.getCarDetailsButton);

        id1.setText(id);
        name.setText(names.get(position));

        return customView;
    }




}