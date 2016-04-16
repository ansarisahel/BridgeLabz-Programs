package com.example.bridgelabz.shoppingpadapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    Toolbar toolbar;
    CardView cardView;
    EditText countryCode,mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        toolbar = (Toolbar) findViewById(R.id.sign_up_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Verify your phone number");
        cardView = (CardView) findViewById(R.id.cardview2);
        countryCode = (EditText) cardView.findViewById(R.id.cardViewEditText1);
        mobileNumber = (EditText) cardView.findViewById(R.id.cardViewEditText2);
        spinner = (Spinner) cardView.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,R.array.country_name,android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(spinnerAdapter);
        spinner.setSelection(11);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.global,menu);
        return true;
    }

    public void onSendMessageButtonClicked(View view)
    {
        boolean mobileNumberIsCorrect = checkMobileNumber(mobileNumber.getText().toString());
        if(mobileNumberIsCorrect)
        {
            try {
                SmsManager smsManager = SmsManager.getDefault();
                String randomNumber = Long.toString((long)Math.ceil(163150 * Math.random()));
                String messsage = "your OTP is "+randomNumber;
                smsManager.sendTextMessage(mobileNumber.getText().toString(), null, messsage , null, null);
               // Toast.makeText(Signup.this, "Message sent", Toast.LENGTH_SHORT).show();
                otpNotify("Shopping pad","your OTP is "+randomNumber);
                startActivity(new Intent(this,OTP.class));

            }
            catch (Exception e)
            {
                Toast.makeText(Signup.this, "Error Occured while try to send a message", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
        else
        Toast.makeText(Signup.this, "Please enter correct mobile number", Toast.LENGTH_SHORT).show();
    }

    // method to check mobile number is correct or not
    private boolean checkMobileNumber(String mobileNumber) {
        Pattern pattern = Pattern.compile("\\b[789]\\d{9}\\b");
        Matcher matcher = pattern.matcher(mobileNumber);
       return matcher.find();
    }

    // method for sending notification message to let user know a OTP message has arrived
    private void otpNotify(String title, String message) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle(title);
        builder.setContentText(message);
        builder.setSmallIcon(R.drawable.facebook_f_logo);


        Intent smsIntent = getPackageManager()
                .getLaunchIntentForPackage(Telephony.Sms.getDefaultSmsPackage(this));
        smsIntent.setType("vnd.android-dir/mms-sms");


        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,smsIntent,0);
        builder.setFullScreenIntent(pendingIntent,false);
        builder.setContentIntent(pendingIntent);            // this will open new activity when clicked on notification
        Notification notification2 = builder.build();

        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(8,notification2);
    }


    // triggered when spinner is clicked
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
        switch(item)
        {
            case "Afghanistan":
                countryCode.setText("+"+93);
                break;
            case "Algeria":
                countryCode.setText("+"+213);
                break;
            case "Argentina":
                countryCode.setText("+"+54);
                break;
            case "Australia":
                countryCode.setText("+"+61);
                break;
            case "Bahrain":
                countryCode.setText("+"+973);
                break;
            case "Bangladesh":
                countryCode.setText("+"+880);
                break;
            case "Belgium":
                countryCode.setText("+"+32);
                break;
            case "Bhutan":
                countryCode.setText("+"+975);
                break;
            case "Brazil":
                countryCode.setText("+"+55);
                break;
            case "Brunei Darussalam":
                countryCode.setText("+"+673);
                break;
            case "Iceland":
                countryCode.setText("+"+354);
                break;
            case "Japan":
                countryCode.setText("+"+81);
                break;
            case "India":
                countryCode.setText("+"+91);
                break;
            case "Kuwait":
                countryCode.setText("+"+965);
                break;
            case "Qatar":
                countryCode.setText("+"+974);
                break;
            case "Singapore":
                countryCode.setText("+"+65);
                break;
            default:
                Toast.makeText(Signup.this, "wrong choice", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
