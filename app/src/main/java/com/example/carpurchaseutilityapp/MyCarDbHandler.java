package com.example.carpurchaseutilityapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyCarDbHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String  DATABASE_NAME = "cardbUtility.db";
    private static final String TABLE_CARS = "cars";
    private static final String COLUMN_CAR_ID = "carid";
    private static final String COLUMN_MODEL = "model";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_RESALE_VALUE = "resalevalue";
    private static final String COLUMN_CAR_NAME = "carname";
    private static final String COLUMN_CID = "cid";

    public MyCarDbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %S (%S INTEGER PRIMARY KEY, %S INTEGER, %S INTEGER,%S DOUBLE,%S VARCHAR(255) NOT NULL, %S VARCHAR(255) NOT NULL);",TABLE_CARS,COLUMN_CAR_ID,
                COLUMN_CID,COLUMN_PRICE,COLUMN_RESALE_VALUE,COLUMN_MODEL,COLUMN_CAR_NAME));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_CARS);
        onCreate(db);
    }

    public void addPurchasedCar(Car car)
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
    }
    public Cursor getCars(int c_id)
    {
        String query = "SELECT * FROM "+TABLE_CARS+" WHERE "+COLUMN_CID+" = "+c_id+";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db!=null)
            cursor = db.rawQuery(query, null);
        return cursor;
    }


    public Cursor getAllCars() {
        String query = "SELECT * FROM "+TABLE_CARS+";";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db!=null)
            cursor = db.rawQuery(query, null);
        return cursor;
    }
}
