package com.example.bridgelabz.swipetabs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by bridgelabz on 4/1/16.
 */
public class Help extends Activity {

    Button btnHelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_layout);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        btnHelp = (Button) findViewById(R.id.btn_help);

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Help.this);
                alertDialog.setTitle("close this activity");
                alertDialog.setMessage("Wanna move to Home Page");
               // alertDialog.setIcon(R.drawable.java1);
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent mainActivity = new Intent(getBaseContext(),MainActivity.class);
                        startActivity(mainActivity);
                    }
                }); // end of positive btn

                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
            }
        }); // end of normal btn
    }
}
