package com.example.bridgelabz.shoppingpadapp.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bridgelabz on 16/2/16.
 */
public abstract class Model extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "shopping_pad";
    public static final int DATABASE_VERSION = 1;

    public Model(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
