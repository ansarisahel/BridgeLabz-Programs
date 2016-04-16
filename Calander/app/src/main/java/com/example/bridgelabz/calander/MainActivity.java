package com.example.bridgelabz.calander;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements DatePicker.OnDateChangedListener {

    DatePicker dp;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = (DatePicker)findViewById(R.id.datePicker1);
        tv = (TextView) findViewById(R.id.textView1);
        dp.setCalendarViewShown(false);
        dp.setSpinnersShown(true);
        dp.init(2014,7,25,onDateChanged);
        dp.setBackgroundColor(Color.BLUE);


    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

    }

    /*DatePicker.OnDateChangedListener onDateChanged= new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(
                DatePicker view,
                int year,
                int monthOfYear,
                int dayOfMonth) {
            TextView tv =
                    (TextView)findViewById(R.id.textView1);
            tv.setText(Integer.toString(monthOfYear+1) +
                    "/"+Integer.toString(dayOfMonth)+
                    "/"+Integer.toString(year) );
        }
    };*/
}

