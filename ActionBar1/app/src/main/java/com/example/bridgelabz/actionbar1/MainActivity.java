package com.example.bridgelabz.actionbar1;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    String[] strings = {"sahel","anas","usman","hamza"};
    AutoCompleteTextView editText;
    ListView listView;
    MenuItem menuItem;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater infalter = getMenuInflater();
        infalter.inflate(R.menu.my_menu,menu);

        menuItem = (MenuItem)menu.findItem(R.id.search);
        View searchView = menuItem.getActionView();
        if (searchView != null)
        {
            editText = (AutoCompleteTextView) searchView.findViewById(R.id.autoCompleteTextView1);
            if(editText != null)
            {
                adapter = new  ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,strings);
                editText.setAdapter(adapter);
                editText.setThreshold(1);
            }
        }
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem view) {
        switch (view.getItemId())
        {
            case R.id.search:
                LinearLayout linearLayout1 = new LinearLayout(this);

                linearLayout1.setId(100);
                setContentView(linearLayout1);

                SearchBtnFragment fragment1 = new SearchBtnFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.add(100,fragment1);
                ft.commit();
                return true;
            case R.id.save:
                Toast.makeText(getBaseContext(),"save has been selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.play:
                Toast.makeText(getBaseContext(),"play has been selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.record:
                Toast.makeText(getBaseContext(),"record has been selected",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(view);
    }

    public boolean onTouchEvent(MotionEvent event)
    {
         if(event.getAction() == MotionEvent.ACTION_DOWN)
         {
             toggleActionBar();
         }
         return true;
     }

    public void toggleActionBar()
    {
        ActionBar actionbar = getActionBar();
        if(actionbar != null)
        {
            if(actionbar.isShowing())
                actionbar.hide();
            else
                actionbar.show();
        }
    }
}
