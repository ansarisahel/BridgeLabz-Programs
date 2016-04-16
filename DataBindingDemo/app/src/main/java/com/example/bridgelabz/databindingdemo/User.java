package com.example.bridgelabz.databindingdemo;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bridgelabz.databindingdemo.BR;

/**
 * Created by bridgelabz on 10/3/16.
 */
public class User extends BaseObservable {
    private String firstName;
    private String lastName;
    private String text1;
    MainActivity context;
    TextView textView;

    public User(MainActivity context, String firstName, String lastName, String text1) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.text1 = text1;
        this.context = context;
        textView = (TextView) context.findViewById(R.id.textView123);
    }

    @Bindable
    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
        notifyPropertyChanged(BR.text1);
    }

    @Bindable
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void OnBtnClick(View view) {
        setLastName("NewLastName");
        setFirstName("New User Firstname");
        setText1("hahaha");
    }

    public void onBtn2Click(View view) {
        setFirstName("hiiii");
        setLastName("Huiii");
    }


    public TextWatcher editTextChanged() {

        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               textView.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }
}