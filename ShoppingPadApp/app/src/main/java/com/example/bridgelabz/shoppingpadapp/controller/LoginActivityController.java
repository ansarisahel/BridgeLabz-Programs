package com.example.bridgelabz.shoppingpadapp.controller;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bridgelabz.shoppingpadapp.Home;
import com.example.bridgelabz.shoppingpadapp.LoginActivity;
import com.example.bridgelabz.shoppingpadapp.R;
import com.example.bridgelabz.shoppingpadapp.Signup;
import com.example.bridgelabz.shoppingpadapp.model.LoginModel1;

/**
 * Created by bridgelabz on 9/2/16.
 */
public class LoginActivityController {

    public static void btnLoginClicked(LoginActivity instance)
    {
        EditText userNameET = (EditText) instance.findViewById(R.id.editTextUserName_login);
        EditText passwordET = (EditText) instance.findViewById(R.id.editTextPasword_login);
        String username = userNameET.getText().toString();
        String password = passwordET.getText().toString();
        //Toast.makeText(instance,username +" "+password,Toast.LENGTH_LONG).show();
        LoginModel1 login_model = new LoginModel1(instance);
        if(username.isEmpty())
        {
            userNameET.setError("please enter userName");
        }
        else if(password.isEmpty())
        {
            passwordET.setError("please enter password");
        }
        else {

            boolean loginSuccessful = login_model.insert(username, password);
            if (loginSuccessful) {
                Toast.makeText(instance, "Login successfully", Toast.LENGTH_SHORT).show();
                instance.startActivity(new Intent(instance, Home.class));
            } else {
                Toast.makeText(instance, "Login is unsuccessful", Toast.LENGTH_SHORT).show();
            }
        }

        //new LoginModel(username,password,instance);

    }

    public static void onSignUpBtnClicked(LoginActivity instance) {
        instance.startActivity(new Intent(instance,Signup.class));
       
    }
}
