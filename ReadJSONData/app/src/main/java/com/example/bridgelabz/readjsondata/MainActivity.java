package com.example.bridgelabz.readjsondata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               
            }
        });
        String strJson="{\"Employee\" :[{\"id\":\"01\",\"name\":\"Gopal Varma\",\"salary\":\"500000\"}, {\"id\":\"02\",\"name\":\"Sairamkrishna\",\"salary\":\"500000\"}, {\"id\":\"03\",\"name\":\"Sathish kallakuri\",\"salary\":\"600000\"} ]}";
        StringBuffer buffer = new StringBuffer();
        try {
            JSONObject jsonObject = new JSONObject(strJson);
            JSONArray jsonArray = jsonObject.optJSONArray("Employee");
            for(int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject object = jsonArray.getJSONObject(i);
                int id = object.getInt("id");
                String name = object.getString("name");
                long salary = object.getLong("salary");
                buffer.append("id = " +id+" name = "+name+" salary = "+salary+"\n");
            }
            textView.setText(buffer);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
