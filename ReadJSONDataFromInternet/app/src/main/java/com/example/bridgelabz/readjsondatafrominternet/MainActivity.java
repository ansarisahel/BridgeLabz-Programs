package com.example.bridgelabz.readjsondatafrominternet;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bridgelabz.readjsondatafrominternet.database.MyDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    InputStream inputStream;
    TextView textView;
    String name,country,twitter;
    Button retrieveBtn,saveIntoDbBtn;
    MyDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting reference of toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // setting toolbar on the activity
        setSupportActionBar(toolbar);

        final String urlString = "http://hmkcode.appspot.com/jsonservlet";

        //creating database by calling database class
        database = new MyDatabase(MainActivity.this);

        // getting reference of textview
        textView = (TextView) findViewById(R.id.textView1);

        // getting reference of retrieve btn
        retrieveBtn = (Button) findViewById(R.id.button1);

        // setting on click listener of retrieve btn
        retrieveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyClass().execute(urlString);
            }
        });

        // getting reference of save btn
        saveIntoDbBtn = (Button) findViewById(R.id.button2);

    }

    // This is the class for handling the network task so that ui threads doesn't get freeze
    public class MyClass extends AsyncTask<String,String,String>
    {
        StringBuffer jsonStringBuffer = new StringBuffer();
        StringBuffer buffer = new StringBuffer();
        String jSONData = null;
        int count = 0;

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                inputStream = connection.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
                String read = null;
                while ((read = in.readLine())!= null)
                {
                    buffer.append(read);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            jSONData = buffer.toString();
            try {
                JSONObject jsonObject;
                JSONArray jsonArray = new JSONArray(jSONData);
                for(int i = 0; i < jsonArray.length(); i++)
                {
                    jsonObject = jsonArray.getJSONObject(i);
                    name = jsonObject.getString("name");
                    country = jsonObject.getString("country");
                    twitter = jsonObject.getString("twitter");
                    long rowsEffected = database.inSertData(name,country,twitter);
                    if(rowsEffected > 0)
                        count++;
                    jsonStringBuffer.append("name :   "+name+"\n country :    "+country+"\n " +
                            "twitter :     "+twitter+"\n\n\n");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            textView.setText(jsonStringBuffer);
            Toast.makeText(MainActivity.this, ""+count+" has been added", Toast.LENGTH_SHORT).show();
        }
    }
}
