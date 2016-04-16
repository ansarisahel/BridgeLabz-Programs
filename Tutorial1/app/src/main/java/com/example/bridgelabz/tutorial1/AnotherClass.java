package com.example.bridgelabz.tutorial1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class AnotherClass extends Activity {

    TextView tv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tv = (TextView) findViewById(R.id.textView1);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //tv.setText(message);
        setContentView(R.layout.class_another);
    }
}
