package com.example.carpurchaseutilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onclickAddCustomer(View view)
    {
        Intent i = new Intent(this,AddCustomerActivity.class);
        startActivity(i);
    }

    public void onclickAddCar(View view) {
        Intent i = new Intent(this,AddCarActivity.class);
        startActivity(i);
    }

    public void onclickGetList(View view) {
        Intent i = new Intent(this,GetFullListActivity.class);
        startActivity(i);
    }

    public void onclickGeneratePrize(View view) {
        Intent i = new Intent(this,GeneratePrizeActivity.class);
        startActivity(i);
    }
}
