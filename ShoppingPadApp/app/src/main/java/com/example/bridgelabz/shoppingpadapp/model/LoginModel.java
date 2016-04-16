package com.example.bridgelabz.shoppingpadapp.model;

import com.example.bridgelabz.shoppingpadapp.LoginActivity;
import com.example.bridgelabz.shoppingpadapp.storage.LoginStorage;

/**
 * Created by bridgelabz on 10/2/16.
 */
public class LoginModel {
    public String username,password;
    public LoginActivity instance;

    public LoginModel(String userName, String password, LoginActivity instance)
    {
        this.username = userName;
        this.password = password;
        this.instance = instance;
        print();
    }

    private void print() {
        new LoginStorage().setInstance(this);
    }




}
