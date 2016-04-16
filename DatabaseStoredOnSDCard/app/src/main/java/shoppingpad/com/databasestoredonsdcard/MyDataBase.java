package shoppingpad.com.databasestoredonsdcard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.support.v4.app.NavUtils;
import android.util.Log;

/**
 * Created by bridgelabz on 4/4/16.
 */
public class MyDataBase extends SQLiteOpenHelper {

    public MyDataBase(Context context) {
        super(context, Environment.getExternalStorageDirectory()+"/MyDatabase", null, 3);
        getWritableDatabase();
        Log.e("db","db");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE EMP(id VARCHAR(30),name VARCHAR(30));");
        Log.e("table","table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.rawQuery("DROP TABLE IF EXISTS EMP",null);
    }


    public void insert()
    {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(Environment.getExternalStorageDirectory()+"/MyDataBase",null,0);
        ContentValues values = new ContentValues();
        values.put("id","abc");
        values.put("name","sahel");
        db.insert("EMP",null,values);
    }

    public Cursor readFromDB()
    {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(Environment.getExternalStorageDirectory()+"/Zip Files Extracted/Content/data/database.sqlite",null,0);
        return db.rawQuery("SELECT * FROM PageMedia",null);
    }

}
