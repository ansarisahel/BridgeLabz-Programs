package com.example.bridgelabz.shoppingpadapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.example.bridgelabz.shoppingpadapp.controller.LoginActivityController;

public class LoginActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
    }

    public void btnLoginClicked(View view) {
        LoginActivityController.btnLoginClicked(this);
    }

    public void onSignUpBtnClicked(View view) {
        LoginActivityController.onSignUpBtnClicked(this);
    }
}
