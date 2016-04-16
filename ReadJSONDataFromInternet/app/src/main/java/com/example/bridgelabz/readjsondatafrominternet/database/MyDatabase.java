package com.example.bridgelabz.readjsondatafrominternet.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.NavUtils;

/**
 * Created by bridgelabz on 7/3/16.
 */
public class MyDatabase extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "myTable";
    private static final String DATABASE_NAME = "myDatabase";
    private static final String COLOUMN_1 = "name";
    private static final String COLOUMN_2 = "country";
    private static final String COLOUMN_3 = "twitter";
    private static final int VERSION = 1;


    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ( "+COLOUMN_1+" VARCHAR(50), "+COLOUMN_2+" VARCHAR(50), "
        +COLOUMN_3+" VARCHAR(50) );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public long inSertData(String name,String country,String twitter)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLOUMN_1,name);
        values.put(COLOUMN_2,country);
        values.put(COLOUMN_3,twitter);
        long rowsEffected = db.insert(TABLE_NAME,null,values);
        return rowsEffected;
    }
}
