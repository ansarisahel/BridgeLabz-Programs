package com.example.bridgelabz.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bridgelabz.databindingdemo.databinding.ContentMainBinding;

public class MainActivity extends AppCompatActivity {

    User user;
    Button button;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.myBtn); 
        ContentMainBinding binding = DataBindingUtil.setContentView(this,R.layout.content_main);
        user = new User(this,"sahel","ansari","hiii");
        binding.setUser(user);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

    }


}
