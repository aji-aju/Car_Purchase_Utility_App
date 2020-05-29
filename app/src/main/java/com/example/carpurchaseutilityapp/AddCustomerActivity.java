package com.example.carpurchaseutilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddCustomerActivity extends AppCompatActivity {

    EditText customerId;
    EditText customerName;
    TextView results;
    public MyDBHandler dbHandler;
    ArrayList<String> customer_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
        customerId = (EditText) findViewById(R.id.editId);
        customerName = (EditText) findViewById(R.id.editName);
        results = (TextView) findViewById(R.id.results);
        dbHandler = new MyDBHandler(this,null,null,1);
    }


    public void addCustomerOnClick(View view) {

        if(customerId.getText().toString().isEmpty()){

            customerId.setError( "ID is required!" );

        }
        else if(customerName.getText().toString().isEmpty())
            customerName.setError("Name is required");
        else{
            Customer customer = new Customer(Integer.parseInt(customerId.getText().toString()),
                    customerName.getText().toString());
            customer_id = new ArrayList<>();
            storeDataInArrays();
            if(customer_id.contains(customerId.getText().toString()))
            {
                customerId.setError( "ID Already Taken!" );
            }
             else{

            dbHandler.addCustomer(customer);
            String msg = "Customer Added";
            Toast toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
            toast.show();
            customerId.setText("");
            customerName.setText("");}
        }



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
            }
        }
    }
}
