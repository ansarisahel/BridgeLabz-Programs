package com.example.bridgelabz.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.jar.Attributes;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student " +
                "( " +
                "ID integer primary key autoincrement," +
                "NAME varchar(20)," +
                "SURNAME varchar(20)," +
                "MARKS integer);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists student");
        onCreate(db);
    }

    public boolean insertData(String name, String surname, int marks)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME",name);
        values.put("SURNAME",surname);
        values.put("MARKS",marks);
        long result = db.insert("student",null,values);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getData()
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor result = db.rawQuery("select * from student",null);
        return result;
    }

    public boolean updateData(String id, String name, String surname, int marks)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME",name);
        values.put("SURNAME",surname);
        values.put("MARKS",marks);
        int upated = db.update("student",values,"ID = ?",new String[] { id });
            return true;

    }
}
