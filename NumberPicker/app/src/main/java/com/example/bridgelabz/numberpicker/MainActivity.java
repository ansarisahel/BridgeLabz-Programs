package com.example.bridgelabz.numberpicker;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.NumberPicker;
import android.widget.TextView;


public class MainActivity extends Activity {

    NumberPicker numberPicker, numberPicker2;
    TextView textView, textView2, textView3;
    String[] string = {"sahel", "anas", "dawood"};
    String[] string1 = new String[10];
    // String temp;

    NumberPicker[] np;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberPicker = (NumberPicker) findViewById(R.id.numberPicker1);
        numberPicker2 = (NumberPicker) findViewById(R.id.numberPicker2);

        textView = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        //textView3 = (TextView) findViewById(R.id.textView3);

        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(10);

        numberPicker2.setMinValue(0);
        numberPicker2.setMaxValue(string.length - 1);
        numberPicker2.setDisplayedValues(string);


        numberPicker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                textView2.setText(string[newVal]);
            }
        });

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                textView.setText(Integer.toString(newVal));
            }
        });

        NumberPicker.OnValueChangeListener onValueChanged
                = new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(
                    NumberPicker picker,
                    int oldVal,
                    int newVal) {
                NumberPicker[] nps = new NumberPicker[3];
                nps[0] = (NumberPicker)
                        findViewById(R.id.numberPicker3);
                nps[1] = (NumberPicker)
                        findViewById(R.id.numberPicker4);
                nps[2] = (NumberPicker)
                        findViewById(R.id.numberPicker5);
                String temp = "";
                for (int i = 0; i < 3; i++) {
                    String[] values = nps[i].getDisplayedValues();
                    temp = values[nps[i].getValue()] + temp;
                }
                TextView tv =
                        (TextView) findViewById(R.id.textView3);
                tv.setText(temp);
            }
        };

        String[] values = new String[10];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.toString(i);
        }

        NumberPicker[] nps = new NumberPicker[3];
        nps[0] = (NumberPicker)
                findViewById(R.id.numberPicker3);
        nps[1] = (NumberPicker)
                findViewById(R.id.numberPicker4);
        nps[2] = (NumberPicker)
                findViewById(R.id.numberPicker5);
        for (int i = 0; i < 3; i++) {
            nps[i].setMaxValue(values.length - 1);
            nps[i].setMinValue(0);
            nps[i].setDisplayedValues(values);
            nps[i].setOnValueChangedListener(onValueChanged);
        }
    }
}
