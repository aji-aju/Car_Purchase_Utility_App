package com.example.carpurchaseutilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GetFullListActivity extends AppCompatActivity {

    public MyDBHandler dbHandler;
    ArrayList<String> customer_id, customer_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_full_list);

        dbHandler = new MyDBHandler(this,null,null,1);
        customer_id = new ArrayList<>();
        customer_name = new ArrayList<>();

        storeDataInArrays();


        final ListAdapter myAdapter = new CustomAdapter(this, customer_id,customer_name);
        final ListView myListView = (ListView) findViewById(R.id.myListView);
        myListView.setAdapter(myAdapter);


    }

    void storeDataInArrays()
    {
        Cursor cursor = dbHandler.getAllCustomers();
        if(cursor.getCount()==0)
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        else
        {
            while (cursor.moveToNext())
            {
                customer_id.add(cursor.getString(0));
                customer_name.add(cursor.getString(1));
            }
        }
    }

    public void getDetails(@org.jetbrains.annotations.NotNull View v)
    {
        LinearLayout vwParentRow = (LinearLayout)v.getParent();
        TextView child = (TextView)vwParentRow.getChildAt(0);

        Intent i = new Intent(this,PurchasedCarsActivity.class);
        i.putExtra("customerId",child.getText().toString());
        startActivity(i);

    }




}
