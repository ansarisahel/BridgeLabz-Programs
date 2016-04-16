package com.example.bridgelabz.dynamic1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    LinearLayout parentLayout;
    ArrayList<String> list = new ArrayList<String>();
    Button print;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentLayout = (LinearLayout) findViewById(R.id.parentLayout);
        abc();

        print = new Button(this);
        print.setText("Print");
        parentLayout.addView(print);
        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Button clicked",Toast.LENGTH_SHORT);
            }
        });


    }

    public void abc() {
        LinearLayout childLayout = new LinearLayout(this);
        childLayout.setOrientation(LinearLayout.HORIZONTAL);

        EditText edit = new EditText(this);

        childLayout.addView(edit);
        list.add(edit.getText().toString());


        Button b1 = new Button(this);
        b1.setText("+");
        childLayout.addView(b1);
        parentLayout.addView(childLayout);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abc();
            }
        });

    }

    public void print()
    {
        for(int i = 0; i < list.size(); i++)
        {

            TextView t = new TextView(getApplicationContext());
            t.setText(list.get(i));
        }
    }

}       // end of class
