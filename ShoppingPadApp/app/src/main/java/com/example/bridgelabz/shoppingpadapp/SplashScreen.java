package com.example.bridgelabz.shoppingpadapp;

import android.app.Activity;
import android.os.Bundle;

import com.example.bridgelabz.shoppingpadapp.controller.HomePageController;

public class SplashScreen extends Activity {

   // private static int SPLASH_TIME_OUT = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        HomePageController.goTOLoginScreen(this);

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);*/
    }
}
