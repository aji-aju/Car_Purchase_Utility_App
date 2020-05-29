package com.example.carpurchaseutilityapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String  DATABASE_NAME = "carPurchaseUtility.db";
    private static final String TABLE_CUSTOMERS = "customers";
    private static final String TABLE_CARS = "cars";
    private static final String COLUMN_CAR_ID = "carid";
    private static final String COLUMN_MODEL = "model";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_RESALE_VALUE = "resalevalue";
    private static final String COLUMN_CAR_NAME = "carname";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_CID = "cid";
    private static final String COLUMN_NAME = "name";

    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_CUSTOMERS
             + " ("+COLUMN_ID+ " INTEGER PRIMARY KEY, "+COLUMN_NAME+ " VARCHAR(255) NOT NULL"+
              ")"
              );

      db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %S (%S INTEGER PRIMARY KEY, %S INTEGER, %S INTEGER,%S DOUBLE,%S VARCHAR(255) NOT NULL, %S VARCHAR(255) NOT NULL);",TABLE_CARS,COLUMN_CAR_ID,
       COLUMN_CID,COLUMN_PRICE,COLUMN_RESALE_VALUE,COLUMN_MODEL,COLUMN_CAR_NAME));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CUSTOMERS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CARS);
        onCreate(db);
    }
    public void addCustomer(Customer customer)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,customer.getId());
        values.put(COLUMN_NAME,customer.getName());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_CUSTOMERS,null,values);
        db.close();
    }
   /* public void addPurchasedCar(Car car)
    {
        ContentValues values = new ContentValues();
        values.put(COLUMN_CAR_ID,car.getId());
        values.put(COLUMN_CID,car.getCustomerId());
        values.put(COLUMN_MODEL,car.getModel());
        values.put(COLUMN_CAR_NAME,car.getName());
        values.put(COLUMN_PRICE,car.getPrice());
        values.put(COLUMN_RESALE_VALUE,car.getResale_value());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_CARS,null,values);
        db.close();
    }  */
  /* Cursor getRandomForPrize()
   {
       String query = "SELECT "+COLUMN_ID+" FROM "+TABLE_CUSTOMERS+" ORDER BY RAND() LIMIT 6;";
       SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = null;
       if(db!=null)
           cursor = db.rawQuery(query, null);
       return cursor;
   } */

    public Cursor getAllCustomers()
    {
        String query = "SELECT * FROM "+TABLE_CUSTOMERS+";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db!=null)
            cursor = db.rawQuery(query, null);
        return cursor;
    }

    /* public Cursor getCars()
    {
        String query = "SELECT * FROM "+TABLE_CARS+";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db!=null)
            cursor = db.rawQuery(query, null);
        return cursor;
    } */



}

