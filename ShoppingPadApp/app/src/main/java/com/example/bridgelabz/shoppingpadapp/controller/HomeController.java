package com.example.bridgelabz.shoppingpadapp.controller;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;

import com.example.bridgelabz.shoppingpadapp.AddContent;
import com.example.bridgelabz.shoppingpadapp.Home;
import com.example.bridgelabz.shoppingpadapp.ViewContent;

/**
 * Created by bridgelabz on 9/2/16.
 */
public class HomeController {

    private static final int SELECT_PICTURE = 1;

    public static void onFloatImageBtnClick(Home instance)
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        // ******** code for crop image
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 0);
        intent.putExtra("aspectY", 0);
        intent.putExtra("outputX", 200);
        intent.putExtra("outputY", 150);

        try {
            intent.putExtra("return-data", true);
            instance.startActivityForResult(Intent.createChooser(intent, "select picture"), SELECT_PICTURE);
        } catch (ActivityNotFoundException e) {

        }
    }

    public static void onActivityResult(Home instance, Bundle extras)
    {
       instance.startActivity(new Intent(instance, AddContent.class).putExtras(extras));
    }


    public static void onFloatVideoBtnClick(Home instance)
    {
        instance.startActivity(new Intent(instance, ViewContent.class));
    }

}
