package com.example.mydatabaseapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CustomerDbHelper extends SQLiteOpenHelper
{
    //DECLARE
    public static String DATABASENAME="CustomerDatabase.db";
    public static int DATABASEVERSION=1;
    public static String TABLENAME="Customer";
    public static String COLUMNONE="CustomerId";
    public static String COLUMNTWO="CustomerName";
    public static String COLUMNTHREE="Gender";
    public static String COLUMNFOUR="Age";
    public static String COLUMNFIVE="Occupation";
    public static String COLUMNSIX="Phone";
    public static String COLUMNSEVEN="Location";
    //declare the create table string wc will create the database
    public static String CREATECUSTOMERTABLE="CREATE TABLE customer (CustomerId INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, CustomerName TEXT NOT NULL, Gender TEXT NOT NULL, Age INTEGER NOT NULL, Occupation TEXT NOT NULL, Phone TEXT NOT NULL, Location TEXT NOT NULL);";
    public CustomerDbHelper(@Nullable Context context)
    {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL(CREATECUSTOMERTABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
        onCreate(sqLiteDatabase);

    }
}
