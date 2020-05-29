package com.example.carpurchaseutilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GeneratePrizeActivity extends AppCompatActivity {
    EditText customer1;
    EditText customer2;
    EditText customer3;
    TextView results;
    ArrayList<String> customerlist;
    public MyDBHandler dbHandler;
    ArrayList<String> customer_id;
    ArrayList<String> allCustomers;
    ArrayList<String> randomCustomers;
    ArrayList<String> winners;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_prize);
        dbHandler = new MyDBHandler(this,null,null,1);
        customer_id = new ArrayList<>();
        customer1 = (EditText) findViewById(R.id.prizeCustomer1);
        customer2 = (EditText) findViewById(R.id.prizeCustomer2);
        customer3 = (EditText) findViewById(R.id.priizeCustomer3);
        results = (TextView) findViewById(R.id.prizeresults);
        results.setText("");
        allCustomers = new ArrayList<String>();

        //customerlist = new HashSet<>();*/
        //customerlist.add(Integer.parseInt(customer1.getText().toString()));
        //customerlist.add(Integer.parseInt(customer2.getText().toString()));
        //customerlist.add(Integer.parseInt(customer3.getText().toString()));
    }


    public void generatePrize(View view) {

        Cursor cursor = dbHandler.getAllCustomers();

            customerlist = new ArrayList<>();
            randomCustomers = new ArrayList<>();
            winners = new ArrayList<>();
            StringBuilder result = new StringBuilder("");
            while (cursor.moveToNext()) {
                allCustomers.add(cursor.getString(0));
            }
        if(allCustomers.size()<6)
        {
            Toast.makeText(this,"Not enough customers to make a draw",Toast.LENGTH_SHORT).show();
        }
        else {
            Random random = new Random();
            for (int i = 0; i < 6; i++) {
                randomCustomers.add(allCustomers.get(random.nextInt(allCustomers.size())));
            }
            customerlist.add(customer1.getText().toString());
            customerlist.add(customer2.getText().toString());
            customerlist.add(customer3.getText().toString());


            for (String customer : customerlist) {
                if (randomCustomers.contains(customer)) {
                    winners.add(customer);
                    result.append(customer + " ");
                }

            }
            if (winners.isEmpty()) {
                Toast toast = Toast.makeText(this, "Oops! No winners", Toast.LENGTH_SHORT);
                toast.show();
                results.setText("");
            } else {
                result.append("wins");
                results.setText(result);
                customer1.setText("");
                customer2.setText("");
                customer3.setText("");
            }

        }

    }
};

