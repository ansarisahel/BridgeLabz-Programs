package com.example.bridgelabz.shoppingpadapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class OTP extends ActionBarActivity {

    static OTP otpInstance;

    public static OTP getInstance()
    {
        return  otpInstance;
    }

    @Override
    protected void onStart() {
        super.onStart();
        otpInstance = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
    }

}
