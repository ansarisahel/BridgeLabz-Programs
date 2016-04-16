package com.example.bridgelabz.cardview;

import android.provider.ContactsContract;

/**
 * Created by bridgelabz on 12/1/16.
 */
public class Contacts {
    int image;
    String name,email,mobileNumber;


    public Contacts(String name,String email,String mobileNumber,int image)
    {
        setName(name);
        setEmail(email);
        setMobileNumber(mobileNumber);
        setImage(image);
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
