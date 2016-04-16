package com.example.bridgelabz.shoppingpadapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by bridgelabz on 21/1/16.
 */
public class MyPagerAdapter  extends FragmentPagerAdapter
{
    String[] tabs = {"Content","View","Contacts"};

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 1) {
            ContentFragment myFragment = ContentFragment.getInstance(position);
            return myFragment;
        }
        else if(position == 2) {
            ContentFragment myFragment = ContentFragment.getInstance(position);
            return myFragment;
        }
        else  {
            ContentFragment myFragment = ContentFragment.getInstance(position);
            return myFragment;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
