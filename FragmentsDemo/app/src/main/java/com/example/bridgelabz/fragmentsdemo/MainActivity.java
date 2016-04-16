package com.example.bridgelabz.fragmentsdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.LinearLayout;

public class MainActivity extends ActionBarActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(100);
        setContentView(linearLayout);

        if(savedInstanceState == null) {
            Fragment1 frag = new Fragment1();
            FragmentManager fm = getFragmentManager();

            FragmentTransaction ft = fm.beginTransaction();
            ft.add(100, frag);
            ft.commit();
        }
    }
}
