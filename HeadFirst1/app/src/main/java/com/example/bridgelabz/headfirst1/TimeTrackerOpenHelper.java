package com.example.bridgelabz.headfirst1;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by bridgelabz on 7/1/16.
 */
public class TimeTrackerOpenHelper extends SQLiteOpenHelper {

    SQLiteDatabase database = getWritableDatabase();
    TimeTrackerOpenHelper(Context context)
    {
        super(context,"timeTracker.dp",null,5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE timerecords" +
                "(" +
                "_id INTEGER PRIMARY KEY,time TEXT,note TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS timerecords ");
        onCreate(db);
    }

    public void saveTimeRecord(String time,String note)
    {

        ContentValues values = new ContentValues();
        values.put("time",time);
        values.put("note",note);
        database.insert("timerecords",null,values);
    }

    public Cursor getAllrecords()
    {
        return database.rawQuery("select * from timerecords",null);
    }
}
