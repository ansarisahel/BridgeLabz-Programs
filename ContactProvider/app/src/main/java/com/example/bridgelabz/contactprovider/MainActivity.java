package com.example.bridgelabz.contactprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    EditText contactNameEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactNameEditText = (EditText) findViewById(R.id.editText1);
    }

    public void addName(View view) {
        String name = contactNameEditText.getText().toString();
        ContentValues values = new ContentValues();
        values.put(ContactProvider.name,name);
        Uri uri = getContentResolver().insert(ContactProvider.CONTENT_URL,values);
        Toast.makeText(getBaseContext(),"Contact Added",Toast.LENGTH_SHORT).show();
    }
}
