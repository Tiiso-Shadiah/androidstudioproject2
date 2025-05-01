package com.example.mydatabaseapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityTwoApp extends AppCompatActivity {
    //declare edittext
    EditText CustomerNameEditText,CustomerGenderEditText,CustomerAgeEditText,CustomerOccupationEditText,CustomerPhoneEditText,CustomerLocEditText;
    //declare save button
    Button SaveCustomerButton;
    //declare the objects of the database
    CustomerDbHelper customerdbhelper;
    SQLiteDatabase customerdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_two_app);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        CustomerNameEditText=findViewById(R.id.CustomerNameEditText);
        CustomerGenderEditText=findViewById(R.id.CustomerGenderEditText);
        CustomerAgeEditText=findViewById(R.id.CustomerAgeEditText);
        CustomerOccupationEditText=findViewById(R.id.CustomerOccupationEditText);
        CustomerPhoneEditText=findViewById(R.id.CustomerPhoneEditText);
        CustomerLocEditText=findViewById(R.id.CustomerLocEditText);
        SaveCustomerButton=findViewById(R.id.SaveCustomerButton);
        customerdbhelper=new CustomerDbHelper(this);
        customerdatabase=customerdbhelper.getWritableDatabase();
        //write the event handler for the Button
        SaveCustomerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //declare strings and integers that will hold the data entered by the user
                String CustomerName=CustomerNameEditText.getText().toString();
                String CustomerGender=CustomerGenderEditText.getText().toString();
                String CustomerOccupation=CustomerOccupationEditText.getText().toString();
                String CustomerLocation=CustomerLocEditText.getText().toString();
                int CustomerAge=Integer.parseInt(CustomerAgeEditText.getText().toString());
                int CustomerPhone=Integer.parseInt(CustomerPhoneEditText.getText().toString());
                //declare an object of the content value class
                ContentValues customervalues=new ContentValues();
                //it takes the column name and values to be inserted
                customervalues.put(CustomerDbHelper.COLUMNTWO,CustomerName);
                customervalues.put(CustomerDbHelper.COLUMNTHREE,CustomerGender);
                customervalues.put(CustomerDbHelper.COLUMNFOUR,CustomerOccupation);
                customervalues.put(CustomerDbHelper.COLUMNFIVE,CustomerLocation);
                customervalues.put(CustomerDbHelper.COLUMNSIX,CustomerAge);
                customervalues.put(CustomerDbHelper.COLUMNSEVEN,CustomerPhone);
                //STUDENT DATABASE.INSERT()
                customerdatabase.insert(CustomerDbHelper.TABLENAME,null,customervalues);
                //declare success message
                Toast.makeText(ActivityTwoApp.this,"One Customer Record Saved Successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
}