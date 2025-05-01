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

public class MainActivity extends AppCompatActivity {
    //declare edittext
    EditText StudentNameEditText,StudentFacultyEditText,StudentCourseEditText,StudentAgeEditText,StudentGenderEditText,StudentFeesEditText,StudentBdEditText;
    //declare save button
    Button SaveStudentButton;
    //declare the objects of the database
    StudentDatabaseHelper studentdatabasehelper;
    SQLiteDatabase studentdatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        StudentNameEditText=findViewById(R.id.StudentNameEditText);
        StudentFacultyEditText=findViewById(R.id.StudentFacultyEditText);
        StudentCourseEditText=findViewById(R.id.StudentCourseEditText);
        StudentAgeEditText=findViewById(R.id.StudentAgeEditText);
        StudentGenderEditText=findViewById(R.id.StudentGenderEditText);
        StudentFeesEditText=findViewById(R.id.StudentFeesEditText);
        StudentBdEditText=findViewById(R.id.StudentBdEditText);
        SaveStudentButton=findViewById(R.id.SaveStudentButton);
        studentdatabasehelper=new StudentDatabaseHelper(this);
        studentdatabase=studentdatabasehelper.getWritableDatabase();
        //write the event handler for the Button
        SaveStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
              //declare strings and integers that will hold the data entered by the user
              String StudentName=StudentNameEditText.getText().toString();
              String StudentFaculty=StudentFacultyEditText.getText().toString();
              String StudentCourse=StudentCourseEditText.getText().toString();
              String StudentBirthDate=StudentBdEditText.getText().toString();
              String StudentGender=StudentGenderEditText.getText().toString();
              int StudentAge=Integer.parseInt(StudentGenderEditText.getText().toString());
              int StudentFees=Integer.parseInt(StudentFeesEditText.getText().toString());
              //declare an object of the content value class
                ContentValues studentvalues=new ContentValues();
                //it takes the column name and values to be inserted
                studentvalues.put(StudentDatabaseHelper.COLUMNTWO,StudentName);
                studentvalues.put(StudentDatabaseHelper.COLUMNTHREE,StudentFaculty);
                studentvalues.put(StudentDatabaseHelper.COLUMNFOUR,StudentCourse);
                studentvalues.put(StudentDatabaseHelper.COLUMNFIVE,StudentBirthDate);
                studentvalues.put(StudentDatabaseHelper.COLUMNSIX,StudentGender);
                studentvalues.put(StudentDatabaseHelper.COLUMNSEVEN,StudentAge);
                studentvalues.put(StudentDatabaseHelper.COLUMNEIGHT,StudentFees);
                //STUDENT DATABASE.INSERT()
                studentdatabase.insert(StudentDatabaseHelper.TABLENAME,null,studentvalues);
                //declare success message
                Toast.makeText(MainActivity.this,"One Student Record Saved Successfully",Toast.LENGTH_LONG).show();
            }
        });


    }
}