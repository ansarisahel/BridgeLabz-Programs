package com.example.bridgelabz.butterknifedatabinding;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.OnLongClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.textView1) TextView t1;
    @Bind(R.id.textView2) TextView t2;
    @Bind(R.id.checkBox1) CheckBox ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        t1.setText("First Text View");

    }
    @OnClick(R.id.button1)
    public void onBClick() {
        t2.setText(t1.getText().toString());
    }
    
    @OnItemSelected(R.id.checkBox1)
    public void itemSelected(int position)
    {
        Toast.makeText(MainActivity.this, "Item Selected", Toast.LENGTH_SHORT).show();
    }
}
