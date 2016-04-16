package com.example.bridgelabz.cardview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Contact_Detail extends ActionBarActivity {

    ImageView imageView;
    TextView name,mobileNumber,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__detail);
        imageView = (ImageView) findViewById(R.id.cdImageView);
        name = (TextView) findViewById(R.id.cdTxtName);
        mobileNumber = (TextView) findViewById(R.id.cdTxtMobileNumber);
        email = (TextView) findViewById(R.id.cdTxtEmail);

        imageView.setImageResource(getIntent().getIntExtra("image",00));
        name.setText(getIntent().getStringExtra("name"));
        mobileNumber.setText(getIntent().getStringExtra("mobileNumber"));
        email.setText(getIntent().getStringExtra("email"));
    }

}
