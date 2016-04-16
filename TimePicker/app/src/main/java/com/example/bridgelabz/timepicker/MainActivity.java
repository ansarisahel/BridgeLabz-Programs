package com.example.bridgelabz.timepicker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends ActionBarActivity {

    TimePicker tp;
    EditText et,hours,minutes;
    TextView automatic;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tp = (TimePicker) findViewById(R.id.timePicker1);
        et = (EditText) findViewById(R.id.editText1);
        hours = (EditText) findViewById(R.id.hours);
        minutes = (EditText) findViewById(R.id.minutes);
        automatic = (TextView) findViewById(R.id.automatic);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                automatic.setText(hourOfDay+":"+minute);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(tp.getCurrentHour().toString()+":"+tp.getCurrentMinute().toString());
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(Integer.parseInt(hours.getText().toString()));
                tp.setCurrentMinute(Integer.parseInt(minutes.getText().toString()));
            }
        });
    }

}
