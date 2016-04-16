package com.example.bridgelabz.getcontacts;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {


    static final Uri CONTENT_URL = Uri.parse("content://com.example.bridgelabz.contactprovider.ContactProvider/cpcontacts");

    TextView contactsTextView = null;
    EditText deleteIdEditText,idLookUpEditText,addNameEditText;
    ContentResolver resolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resolver = getContentResolver();
        contactsTextView = (TextView) findViewById(R.id.textView1);
        deleteIdEditText = (EditText) findViewById(R.id.editText1);
        idLookUpEditText = (EditText) findViewById(R.id.editText2);
        addNameEditText = (EditText) findViewById(R.id.editText3);

        getContacts();
    }

    public void getContacts()
    {
        String[] projection = new String[]{"id","name"};
        String contactList = "";
        Cursor cursor = resolver.query(CONTENT_URL,projection,null,null,null);
        if(cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    String id = cursor.getString(cursor.getColumnIndex("id"));
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    contactList = contactList + id + " : " + name + "\n";
                } while (cursor.moveToNext());
            }
        }
        else
        Toast.makeText(this,"No Contacts are saved in the database",Toast.LENGTH_SHORT).show();
        contactsTextView.setText(contactList);
    }


    public void deleteContacts(View view)
    {
        String idToDelete =  deleteIdEditText.getText().toString();
        long idDeleted = resolver.delete(CONTENT_URL,"id = ? ",new String[]{idToDelete});
        getContacts();
    }

    public void lookUpContacts(View view) {
        String idToFind = idLookUpEditText.getText().toString();
        String[] projection = {"id","name"};
        Cursor cursor = resolver.query(CONTENT_URL,projection,"id = ?",new String[]{idToFind},null);
        String contact = "";
        if(cursor.moveToFirst())
        {
            String id = cursor.getString(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            contact = contact + id +" : "+name+"\n";
        }
        else
            Toast.makeText(this,"Contact not found",Toast.LENGTH_SHORT).show();
            contactsTextView.setText(contact);

    }

    public void addContacts(View view) {
        String contactToAdd = addNameEditText.getText().toString();
        ContentValues name = new ContentValues();
        name.put("name",contactToAdd);
        resolver.insert(CONTENT_URL,name);
        getContacts();
    }

    public void showContacts(View view) {
        getContacts();
    }
}
