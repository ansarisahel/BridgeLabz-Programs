package com.example.bridgelabz.headfirst1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class TimeTracker extends ActionBarActivity {

    private static final int TIME_ENTRY_REQEST_CODE = 1;
    ListView listView;
    TimeTrackerAdapter adapter;
    TimeTrackerOpenHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new TimeTrackerOpenHelper(this);
        adapter = new TimeTrackerAdapter(this,databaseHelper.getAllrecords());
        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_time_menu_item_) {
            Intent addTimeActivity = new Intent(this,AddTimeActivity.class);
            startActivityForResult(addTimeActivity,1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == TIME_ENTRY_REQEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                String notes = data.getStringExtra("note");
                String time = data.getStringExtra("time");
                databaseHelper.saveTimeRecord(time,notes);
                adapter.changeCursor(databaseHelper.getAllrecords());

            }
        }
    }
}
