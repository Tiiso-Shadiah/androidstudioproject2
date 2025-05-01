package com.example.mydatabaseapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StudentDatabaseHelper extends SQLiteOpenHelper
{// declare static database attributes
    public static String DATABASENAME="StudentDatabase.db";
    public static int DATABASEVERSION=1;
    public static String TABLENAME="Student";
    public static String COLUMNONE="StudentId";
    public static String COLUMNTWO="StudentName";
    public static String COLUMNTHREE="Faculty";
    public static String COLUMNFOUR="Course";
    public static String COLUMNFIVE="Age";
    public static String COLUMNSIX="Gender";
    public static String COLUMNSEVEN="Fees";
    public static String COLUMNEIGHT="BirthDate";
    //declare the create table string wc will create the database
    public static String CREATESTUDENTTABLE="CREATE TABLE student (StudentId INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL, StudentName TEXT NOT NULL, Faculty TEXT NOT NULL, Course TEXT NOT NULL, Age INTEGER NOT NULL, Gender TEXT NOT NULL, Fees INTEGER NOT NULL, BirthDate TEXT NOT NULL);";


    public StudentDatabaseHelper(@Nullable Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
       sqLiteDatabase.execSQL(CREATESTUDENTTABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLENAME);
        onCreate(sqLiteDatabase);

    }
}
