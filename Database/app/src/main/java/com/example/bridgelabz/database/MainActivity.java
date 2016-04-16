package com.example.bridgelabz.database;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    DatabaseHelper db;

    Button addData,showAllData,updateData;
    EditText name,surname,marks,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        addData = (Button) findViewById(R.id.btnAdd);
        updateData = (Button) findViewById(R.id.btnUpdate);
        name = (EditText) findViewById(R.id.editText);
        surname = (EditText) findViewById(R.id.editText2);
        marks = (EditText) findViewById(R.id.editText3);
        id = (EditText) findViewById(R.id.editText4);
        showAllData = (Button) findViewById(R.id.btnShowData);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });

        showAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAll();
            }
        });

        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        });
    }

    void addData()
    {
        boolean result = db.insertData(name.getText().toString(),surname.getText().toString(),Integer.parseInt(marks.getText().toString()));
        if(result)
            Toast.makeText(this,"Data inserted sucessfully",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Data inserted failed",Toast.LENGTH_SHORT).show();
    }

    public void showAll()
    {
        Cursor resultSet = db.getData();
        if(resultSet.getCount() == 0)
        {
            showMessage("Error","Nothing found");
        }
        else
        {
            StringBuffer buffere = new StringBuffer();
            while(resultSet.moveToNext()) {
                buffere.append("Id :"+resultSet.getString(0)+"\n");
                buffere.append("Name :"+resultSet.getString(1)+"\n");
                buffere.append("Surname :"+resultSet.getString(2)+"\n");
                buffere.append("Marks :"+resultSet.getString(3)+"\n\n");
            }
            showMessage("Data",buffere.toString());
        }
    }

    public void updateData()
    {
        boolean result = db.updateData(id.getText().toString(),name.getText().toString(),surname.getText().toString(),Integer.parseInt(marks.getText().toString())) ;
        if(result)
            Toast.makeText(this,"Data updated",Toast.LENGTH_SHORT);
        else
            Toast.makeText(this,"Data update failed",Toast.LENGTH_SHORT);
    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setCancelable(true);
        builder.setMessage(message);
        builder.show();
    }




}
