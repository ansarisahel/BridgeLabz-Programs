package com.example.bridgelabz.myapplication;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView isConnected;
    EditText etName,etCountry,etTwitter;
    Button btnPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        isConnected = (TextView) findViewById(R.id.tvIsConnected);
        etName = (EditText) findViewById(R.id.etName);
        etCountry = (EditText) findViewById(R.id.etCountry);
        etTwitter = (EditText) findViewById(R.id.etTwitter);
        btnPost = (Button) findViewById(R.id.btnPost);
        if(isConnected()) {
            isConnected.setText("Your are connected");
            isConnected.setBackgroundColor(0xFF00CC00);
        }
        else {
            isConnected.setText("You are not connected to the internet");
            isConnected.setBackgroundColor(getResources().getColor(R.color.redColor));
        }

        btnPost.setOnClickListener(this);
    }

    public String post(String url, Person person)
    {
        InputStream inputstream = null;
        String result = "";
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);
            String json = "";
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("name",etName.getText().toString());
            jsonObject.accumulate("country",etCountry.getText().toString());
            jsonObject.accumulate("twitter",etTwitter.getText().toString());

            json = jsonObject.toString();
            StringEntity se = new StringEntity(json);
            post.setEntity(se);
            post.setHeader("Accept","application/json");
            post.setHeader("Content-type","application/json");
            HttpResponse httpResponse = httpClient.execute(post);
            inputstream = httpResponse.getEntity().getContent();
            if (inputstream != null)
                result  = convertInputStreamTOString(inputstream);
            else
                result = "didn't work";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            Person person = new Person();
            person.setName(etName.getText().toString());
            person.setCountry(etName.getText().toString());
            person.setTwitter(etTwitter.getText().toString());
            return post(urls[0],person);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Data Sent!", Toast.LENGTH_LONG).show();
        }
    }

    private String convertInputStreamTOString(InputStream inputstream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputstream));
        String line,result = null;
        while ((line = in.readLine()) != null)
        {
            result += line;
        }
        return result;
    }

    private boolean isConnected() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null || networkInfo.isConnected())
            return  true;
        else
            return  false;
    }


    @Override
    public void onClick(View view) {
        if(!validate())
        {
            Toast.makeText(MainActivity.this, "please provide all the information", Toast.LENGTH_SHORT).show();
        }
        else
        {
            new HttpAsyncTask().execute("http://hmkcode.appspot.com/jsonservlet");
        }
    }

    public boolean validate()
    {
        if(etName.getText().toString().trim().equals(""))
            return false;
        else if(etCountry.getText().toString().trim().equals(""))
            return false;
        else if(etTwitter.getText().toString().trim().equals(""))
            return false;
        return true;
    }
}
