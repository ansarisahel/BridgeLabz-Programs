package com.example.bridgelabz.shoppingpadapp.storage;

import android.widget.Toast;

import com.example.bridgelabz.shoppingpadapp.model.LoginModel;

/**
 * Created by bridgelabz on 10/2/16.
 */
public class LoginStorage {
    LoginModel login_model_instance;

    public void setInstance(LoginModel instance)
    {
        login_model_instance = instance;
        printInstanceData();
    }

    private void printInstanceData() {
        Toast.makeText(login_model_instance.instance, "user name is "+login_model_instance.username, Toast.LENGTH_SHORT).show();
    }


}
