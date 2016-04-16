package com.example.bridgelabz.downloadimagefromtheinternet.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bridgelabz on 7/3/16.
 */
public class MyDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "myDatabase";
    private static final String TABLE_NAME = "myTable";
    private static final String COLUMN_1 = "myDatabase";
    private static final String COLUMN_2 = "myDatabase";
    private static final String COLUMN_3 = "myDatabase";

    public MyDatabase(Context context
    ) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
