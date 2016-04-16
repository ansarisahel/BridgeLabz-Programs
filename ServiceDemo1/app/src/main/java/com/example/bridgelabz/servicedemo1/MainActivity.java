package com.example.bridgelabz.servicedemo1;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText et;
    boolean status;
    MyService mservice = new MyService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.editText1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void boundService(View v)
    {
        Intent i = new Intent(this,MyService.class);
        bindService(i,sc, Context.BIND_AUTO_CREATE);
        status = true;
        Toast.makeText(this,"Service binded successfully",Toast.LENGTH_SHORT);
    }

    public void unBoundService(View v)
    {
        unbindService(sc);
        if(status)
            Toast.makeText(this, "Service unbiunded successfully", Toast.LENGTH_SHORT);
        else
            Toast.makeText(this, "Bind the service first", Toast.LENGTH_SHORT);
    }

    public void factorialmain(View v)
    {
        if(status)
        {
            int number = Integer.parseInt(et.getText().toString());
            int result = mservice.factorial(number);
            Toast.makeText(this, "Factorial of a number is "+result, Toast.LENGTH_SHORT);
        }
        else
            Toast.makeText(this, "Bind the service first", Toast.LENGTH_SHORT);
    }


    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.LocalBinder binder = (MyService.LocalBinder) service;
            mservice = binder.getService();
            status = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}
