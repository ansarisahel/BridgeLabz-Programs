package com.example.bridgelabz.shoppingpadapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by bridgelabz on 16/2/16.
 */
public class LoginModel1 extends Model {
    public static final String TABLE_NAME = "loginTbl";
    public static final String COLOUMN1 = "user_name";
    public static final String COLOUMN2 = "password";

    public LoginModel1(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"("
                +COLOUMN1+" VARCHAR(20),"
                +COLOUMN2+" VARCHAR(20));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DELETE TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insert(String userName, String password)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLOUMN1,userName);
        values.put(COLOUMN2,password);
        long rowsEffected = db.insert(TABLE_NAME,null,values);
        if(rowsEffected > 0)
            return true;
        else
            return false;
    }
}
