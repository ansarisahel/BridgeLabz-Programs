package com.example.bridgelabz.swipetabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by bridgelabz on 16/12/15.
 */
public class FragmentPageAdapter extends FragmentPagerAdapter {
    public FragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return new Java();
            case 1:
                return  new DotNet();
            case 2:
                return new Php();
            default:
                break;
        }
        return null;
    }


    @Override
    public int getCount() {
        return 3;
    }
}
