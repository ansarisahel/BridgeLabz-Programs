package com.example.bridgelabz.headfirst2;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends ActionBarActivity {

    private static final int PICK_CONTACT_REQUEST = 0;
    ContentResolver contentResolver = getContentResolver();
    // Cursor cur = getContentResolver().query(getIntent().getData,null,null,null,null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        renderContact(null);
    }

    private void renderContact(Uri uri) {
        TextView contactNameView = (TextView) findViewById(R.id.contact_name);
        TextView contactPhoneView = (TextView) findViewById(R.id.contact_phone);
        ImageView photoView = (ImageView) findViewById(R.id.contact_photo);

        if(uri == null) {
            contactNameView.setText("Please select contact");
            contactPhoneView.setText("");
            photoView.setImageBitmap(null);
        }
        else
        {
            contactNameView.setText(getDisplayName(uri));
            contactPhoneView.setText(getMobileNumber(uri));
            photoView.setImageBitmap(getPhoto(uri));
        }
    }

    private Bitmap getPhoto(Uri uri) {
        Bitmap photo = null;
        String id = null;
        Cursor contactCursor = getContentResolver().query(uri,new String[]{ContactsContract.Contacts._ID},null,null,null);
        if(contactCursor.moveToFirst())
        {
            id = contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.Contacts._ID));
        }
        contactCursor.close();
        try
        {
            InputStream input = ContactsContract.Contacts.openContactPhotoInputStream (
                    getContentResolver(),
                    ContentUris.withAppendedId(

                            ContactsContract.Contacts.CONTENT_URI,

                            new Long(id).longValue()));
            if (input != null)
            {
                photo = BitmapFactory.decodeStream(input);
            }
            input.close();
        }catch (IOException e)
        {}
        return photo;
    }


    private String getMobileNumber(Uri uri) {
        return null;
    }


    private String getDisplayName(Uri uri) {
        String displayName = null;
     /*   Cursor contactCursor = getContentResolver().query(uri,new String[]{ContactsContract.Contacts.DISPLAY_NAME},null,null,null);
        if(contactCursor.moveToFirst())
        {
            displayName = contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
        }
        contactCursor.close();*/
        return displayName;
    }

    public void onUpdateContact(View view)
    {
        startActivityForResult(new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI),PICK_CONTACT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(requestCode == PICK_CONTACT_REQUEST)
        {
            if(resultCode == RESULT_OK)
            {
                Log.d("selection",intent.toString());
                renderContact(intent.getData());
            }
        }
    }


}
