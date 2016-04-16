package com.example.bridgelabz.popuplist;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    Button b1 = (Button) findViewById(R.id.btnPopUp);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder helpBuilder = new AlertDialog.Builder(MainActivity.this);
                helpBuilder.setTitle("POP Message");
                helpBuilder.setMessage("This is the popo up message box");
                helpBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alert = helpBuilder.create();
                alert.show();
            }

        });

    }



    public void showSimpleDialog()
    {
        PopUp dialog = new PopUp();
        dialog.show(getFragmentManager(),"abc");
    }
}
