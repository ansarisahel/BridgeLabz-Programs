package com.example.bridgelabz.registration;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void radioButtonClicked(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.male:
                if(checked)
                    Log.d("radio button","male is checked");
                    break;
            case R.id.female:
                if(checked)
                    Log.d("radio button","female is checked");
                break;
        }
    }

    public void checkBoxClicked(View view)
    {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId())
        {
            case R.id.mango:
                if(checked) {
                    Log.d("check box","mango is checked");
                    break;
                }
            case R.id.apple:
                if(checked) {
                    Log.d("check box","apple is checked");
                    break;
                }
        }
    }   // end of method

}
