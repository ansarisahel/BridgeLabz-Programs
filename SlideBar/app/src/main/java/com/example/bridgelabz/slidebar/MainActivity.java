package com.example.bridgelabz.slidebar;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {

    public EditText editText;
    public SeekBar sb;
    public CheckBox cb;
    int width = 10, lenth = 20;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        sb = (SeekBar) findViewById(R.id.seekBar);
        cb = (CheckBox) findViewById(R.id.checkbox);

        sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {

                int volume = progresValue * width * lenth;
                editText.setText(Integer.toString(volume));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });


    }

    public void checkBoxClicked(View view)
    {

        if(((CheckBox)view).isChecked() == true)
        {
            sb.setEnabled(false);
        }
        else
        {
            sb.setEnabled(true);
        }
    }
}

