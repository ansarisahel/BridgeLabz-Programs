package com.example.bridgelabz.insertimageintodatabase;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.IntegerRes;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by bridgelabz on 17/2/16.
 */
public class MyDatabase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "insert_image";
    public static final String TABLE_NAME = "image_table";
    public static final String COLOUMN1 = "id";
    public static final String COLOUMN2 = "image_uri";
    public static final int VERSION = 5;
    Context context;
    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ( "+COLOUMN1 +" PRIMARY_KEY AUTO INCREMENT, "+COLOUMN2+" VARCHAR(220) );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public long insertImage(byte[] imageUri)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLOUMN2,imageUri.toString());
        long rowsChanged = db.insert(TABLE_NAME,null,values);
        return rowsChanged;
    }

    public String retrieveImage()
    {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("select "+COLOUMN2+" from "+TABLE_NAME,null);
        if(cursor.moveToLast())
        {
            String imageByte = cursor.getString(0);
            return imageByte;
        }
        cursor.close();
        return null;
    }
}
