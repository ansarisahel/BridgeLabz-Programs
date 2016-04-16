package com.example.bridgelabz.shoppingpadapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.cookie.CookieAttributeHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bridgelabz on 3/2/16.
 */
public class SmsReciever extends BroadcastReceiver {

    public String otp = null;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        try {
            if (bundle != null) {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                  //  String senderNum = currentMessage.getDisplayOriginatingAddress();
                    String message = currentMessage.getDisplayMessageBody();
                    boolean otpFound = getOTP(message);

                    if(otpFound) {
                        Toast.makeText(context,otp,Toast.LENGTH_SHORT).show();
                        OTP otpInstance = OTP.getInstance();
                        EditText et = (EditText) otpInstance.findViewById(R.id.otpEditText1);
                        et.setText(otp);
                    }
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }       // end of onReceive method

    private boolean getOTP(String message) {
        Pattern pattern = Pattern.compile("\\b[0-9]{6}\\b");
        Matcher match = pattern.matcher(message);
        if(match.find())
        {
            otp = match.group(0);
            return true;
        }
        else
            return false;
    }
}       // end of class