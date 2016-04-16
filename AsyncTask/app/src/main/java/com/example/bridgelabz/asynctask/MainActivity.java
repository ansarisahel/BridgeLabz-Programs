package com.example.bridgelabz.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] strings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        strings = getResources().getStringArray(R.array.strings);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>()));
        new MyTask().execute();
    }

    class MyTask extends AsyncTask
    {
        ArrayAdapter<String> adapter;
        @Override
        protected void onPreExecute() {
            adapter = (ArrayAdapter<String>)listView.getAdapter();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            for(String string : strings)
            {
                publishProgress(string);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            adapter.add((String)values[0]);
        }

        @Override
        protected void onPostExecute(Object o) {
            Toast.makeText(MainActivity.this, "Added Sucessfully", Toast.LENGTH_SHORT).show();
        }
    }

}
