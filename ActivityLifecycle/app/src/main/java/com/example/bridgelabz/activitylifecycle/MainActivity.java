package com.example.bridgelabz.activitylifecycle;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    TextView tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView1);
        tv.append("onCreate \n");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        tv.append("onPause \n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv.append("onResume \n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        tv.append("onStop \n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tv.append("onDestroy\n");
    }

    @Override
    protected void onStart() {
        super.onStart();
        tv.append("onStart \n");
    }
}
