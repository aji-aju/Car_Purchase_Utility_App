package com.example.carpurchaseutilityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddCarActivity extends AppCompatActivity {

    EditText customerId;
    EditText carId;
    EditText model;
    EditText price;
    String carType;
    ArrayList<String> car_id;
    ArrayList<String> customer_id;
    MyCarDbHandler dbHandler;
    MyDBHandler dbHandler1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        customerId = (EditText) findViewById(R.id.editId1);
        carId = (EditText) findViewById(R.id.editCarId);
        model = (EditText) findViewById(R.id.editModel);
        price = (EditText) findViewById(R.id.editPrice);
        Spinner carTypes = (Spinner) findViewById(R.id.spinnerCarType);
        carType = String.valueOf(carTypes.getSelectedItem());
        dbHandler = new MyCarDbHandler(this,null,null,1);
        dbHandler1 = new MyDBHandler(this,null,null,1);

    }

    public void addCarOnClick(View view) {
        Car car;

        if(customerId.getText().toString().isEmpty()){

            customerId.setError( "ID is required!" );

        }
        else if(carId.getText().toString().isEmpty()){

            carId.setError( "Car ID is required!" );

        }
        else if(model.getText().toString().isEmpty()){

            model.setError( "Model is required!" );

        }
        else if(price.getText().toString().isEmpty()){

            price.setError( "Price is required!" );

        }
        else{
            car_id = new ArrayList<>();
            storeDataInArrays();
            if(car_id.contains(carId.getText().toString()))
            {
                carId.setError( "Car ID Already Taken!" );
            }
            else {
                customer_id = new ArrayList<>();
                storeCustomerInArrays();
                if(!customer_id.contains(customerId.getText().toString()))
                {
                    customerId.setError( "Customer Not Added!" );

                }
                else{
                switch (carType) {
                    case "Toyota":
                        car = new Toyota(Integer.parseInt(customerId.getText().toString()), Integer.parseInt(carId.getText().toString()),
                                model.getText().toString(), Integer.parseInt(price.getText().toString()));
                        break;
                    case "Hyundai":
                        car = new Hyundai(Integer.parseInt(customerId.getText().toString()), Integer.parseInt(carId.getText().toString()),
                                model.getText().toString(), Integer.parseInt(price.getText().toString()));
                        break;
                    case "Maruti":
                        car = new Maruti(Integer.parseInt(customerId.getText().toString()), Integer.parseInt(carId.getText().toString()),
                                model.getText().toString(), Integer.parseInt(price.getText().toString()));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + carType);
                }

                String msg = "Car Added";
                dbHandler.addPurchasedCar(car);
                Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
                toast.show();
                customerId.setText("");
                carId.setText("");
                model.setText("");
                price.setText("");
            }
    }
        }
    }

    void storeDataInArrays()
    {
        Cursor cursor = dbHandler.getAllCars();
        if(cursor.getCount()==0)
            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
        else
        {
            while (cursor.moveToNext())
            {
                car_id.add(cursor.getString(0));
            }
        }
    }
    void storeCustomerInArrays()
    {
        Cursor cursor = dbHandler1.getAllCustomers();
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
