package com.example.carpurchaseutilityapp;

import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PurchasedCarsActivity extends AppCompatActivity {

    public MyCarDbHandler dbHandler;
    ArrayList<String> car_id, car_name,car_model,car_price,car_resale_value;
    String customerId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchased_cars);
       Bundle data = getIntent().getExtras();

      // dbHandler = new MyDBHandler(this,null,null,1);
       customerId = data.getString("customerId");
       car_id = new ArrayList<>();
       car_resale_value = new ArrayList<>();
       car_price = new ArrayList<>();
       car_model = new ArrayList<>();
       car_name = new ArrayList<>();
       car_resale_value.add("Resale Value");
       car_price.add("Price");
       car_model.add("Model");
       car_id.add("ID");
       car_name.add("Name");
       dbHandler = new MyCarDbHandler(this,null,null,1);
        storeDataInArrays();
     //  Toast toast = Toast.makeText(this,car_model.get(0),Toast.LENGTH_SHORT);
       //toast.show();

        ListAdapter myAdapter = new CustomAdapterForCars(this,car_id,car_name,car_model,car_price,car_resale_value);
        final ListView myCarView = (ListView) findViewById(R.id.myCarView);
        myCarView.setAdapter(myAdapter);

    }

    void storeDataInArrays()
    {

        Cursor cursor = dbHandler.getCars(Integer.parseInt(customerId));
        if(cursor.getCount()==0)
            Toast.makeText(this,"No Cars Purchased",Toast.LENGTH_SHORT).show();
        else
        {

            while (cursor.moveToNext())
            {
                car_id.add(cursor.getString(0));
                car_name.add(cursor.getString(5));
                car_model.add(cursor.getString(4));
                car_price.add(cursor.getString(2));
                car_resale_value.add(cursor.getString(3));

            }
        }
       cursor.close();
    }

}
