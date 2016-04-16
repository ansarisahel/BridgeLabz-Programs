package com.example.bridgelabz.readjsonfromfile;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = new Intent();
        textView = (TextView) findViewById(R.id.textView);
        try {
            FileInputStream fileInputStream = openFileInput("JsonString");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader in = new BufferedReader(inputStreamReader);
            //StringBuffer buffer = new StringBuffer();
            String jsonString = null;
            String line;
            while((line = in.readLine()) != null)
            {
                jsonString += line;
            }

            textView.setText(jsonString);
            JSONObject color = new JSONObject(jsonString);
            JSONObject mainColor = color.getJSONObject("main color");
            JSONObject tempColor = color.getJSONObject("temp color");
            JSONObject red = mainColor.getJSONObject("red");

                line = line + red.getString("cherry");
                line = line +"\n"+ red.getString("apple");

            textView.setText(line);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
