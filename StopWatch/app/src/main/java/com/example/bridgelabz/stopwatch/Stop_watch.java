package com.example.bridgelabz.stopwatch;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Stop_watch extends AppCompatActivity {

    int seconds = 0;
    boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(savedInstanceState != null)
        {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
        runTimer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        running = false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("seconds" , seconds);
        outState.putBoolean("running",running);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        running = true;
    }

    private void runTimer() {

        final Handler handler = new Handler();
        final TextView textView = (TextView) findViewById(R.id.timeTxt);
        handler.post(new Runnable() {
            @Override
            public void run() {
                int secs = seconds % 60;
                int minutes = (seconds % 3600)/60;
                int hours = seconds / 3600;
                String time = String.format("%d:%02d:%02d",hours,minutes,secs);
                textView.setText(time);
                if(running)
                {
                   seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }


    public void onStartBtnClick(View view) {
        running = true;
    }

    public void onStopBtnClick(View view) {
        running = false;
    }

    public void onResetBtnClick(View view) {
        running = false;
        seconds = 0;
    }
}
