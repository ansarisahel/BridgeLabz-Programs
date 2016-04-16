package com.example.bridgelabz.shoppingpadapp.controller;

import android.content.Intent;
import android.os.Handler;

import com.example.bridgelabz.shoppingpadapp.LoginActivity;
import com.example.bridgelabz.shoppingpadapp.SplashScreen;

/**
 * Created by bridgelabz on 9/2/16.
 */
public class HomePageController {

    private static int SPLASH_TIME_OUT = 1000;
    public static void goTOLoginScreen(final SplashScreen instance)
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(instance, LoginActivity.class);
                instance.startActivity(i);
                instance.finish();
            }
        },SPLASH_TIME_OUT);
    }
}
