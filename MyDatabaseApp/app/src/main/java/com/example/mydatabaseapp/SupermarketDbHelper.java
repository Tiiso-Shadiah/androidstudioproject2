package com.example.mydatabaseapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SupermarketDbHelper extends SQLiteOpenHelper {
    public static String DATABASENAME="SupermarketDb.db";
    public static int DATABASEVERSION=1;
    public static String TABLEONE="Product";
    public static String TABLETWO="Sales";
    public static String TABLETHREE="Worker";
    public static String TABLEFOUR="Customer";
    //for table one
    public static String TABLEONECOLUMNONE="ProductId";
    public static String TABLEONECOLUMNTWO="ProductName";
    public static String TABLEONECOLUMNTHREE="Price";
    public static String TABLEONECOLUMNFOUR="Quantity";
    public static String TABLEONECOLUMNFIVE="Supplier";
    public static String TABLEONECOLUMNSIX="ExpiryDate";
    //for table two
    public static String TABLETWOCOLUMNONE="SalesId";
    public static String TABLETWOCOLUMNTWO="ProductName";
    public static String TABLETWOCOLUMNTHREE="Price";
    public static String TABLETWOCOLUMNFOUR="Quantity";
    public static String TABLETWOCOLUMNFIVE="Cost";
    public static String TABLETWOCOLUMNSIX="Tax";
    public static String TABLETWOCOLUMNSEVEN="SalesDate";
    //for table three
    public static String TABLETHREECOLUMNONE="WorkerId";
    public static String TABLETHREECOLUMNTWO="WorkerName";
    public static String TABLETHREECOLUMNTHREE="Salary";
    public static String TABLETHREECOLUMNFOUR="Dept";
    public static String TABLETHREECOLUMNFIVE="Age";
    public static String TABLETHREECOLUMNSIX="Position";
    //for table four
    public static String TABLEFOURCOLUMNONE="CustomerId";
    public static String TABLEFOURCOLUMNTWO="Gender";
    public static String TABLEFOURCOLUMNTHREE="Age";
    public static String TABLEFOURCOLUMNFOUR="Phone";
    public static String TABLEFOURCOLUMNFIVE="Email";
    public static String TABLEFOURCOLUMNSIX="Location";
    //FOR TABLE ONE
    public static String CREATETABLEONE="CREATE TABLE product (ProductId INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, ProductName TEXT NOT NULL, Price REAL NOT NULL, Quantity INTEGER NOT NULL, Supplier TEXT NOT NULL, ExpiryDate TEXT NOT NULL);";
    //FOR TABLE TWO
    public static String CREATETABLETWO="CREATE TABLE sales (SalesId INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, ProductName TEXT NOT NULL, Price REAL NOT NULL, Quantity INTEGER NOT NULL, Cost REAL NOT NULL, Tax REAL NOT NULL, SalesDate TEXT NOT NULL);";
    //FOR TABLE THREE
    public static String CREATETABLETHREE="CREATE TABLE worker (WorkerId INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, WorkerName TEXT NOT NULL, Salary REAL NOT NULL, Dept REAL NOT NULL, Age INTEGER NOT NULL, Position TEXT NOT NULL);";
    //FOR TABLE FOUR
    public static String CREATETABLEFOUR="CREATE TABLE customer (CustomerId INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, Gender TEXT NOT NULL, Age INTEGER NOT NULL, Phone TEXT NOT NULL, Email TEXT NOT NULL, Location TEXT NOT NULL);";

    public SupermarketDbHelper(@Nullable Context context, @Nullable String name) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATETABLEONE);
        sqLiteDatabase.execSQL(CREATETABLETWO);
        sqLiteDatabase.execSQL(CREATETABLETHREE);
        sqLiteDatabase.execSQL(CREATETABLEFOUR);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLEONE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLETWO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLETHREE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLEFOUR);
        onCreate(sqLiteDatabase);



    }
}
