package shoppingpad.com.databasestoredonsdcard;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MyDataBase dataBase = new MyDataBase(this);
        dataBase.insert();
        Cursor cursor = dataBase.readFromDB();
        if (cursor != null)
        {
            while (cursor.moveToNext())
            {
                Log.e("page_id",cursor.getString(cursor.getColumnIndex("page_id")));
                Log.e("page_media",cursor.getString(cursor.getColumnIndex("page_media_type")));
                Log.e("loc_x",cursor.getString(cursor.getColumnIndex("loc_x")));
                Log.e("loc_y",cursor.getString(cursor.getColumnIndex("loc_y")));
                Log.e("media_wt",cursor.getString(cursor.getColumnIndex("media_wt")));
                Log.e("media_ht",cursor.getString(cursor.getColumnIndex("media_ht")));
                Log.e("media_file",cursor.getString(cursor.getColumnIndex("media_file")));
            }
        }
    }
}
