package com.example.bridgelabz.materialdesign;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment implements MyAdapter.ClickListener {

    RecyclerView recyclerView;

    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout mDrawerLayout;
    public static final String KEY_USER_LEARNED_DRAWER ="user_learned_drawer";
    View containerView;
    boolean mUserLearnedDrawer;
    boolean mFromSavedInstanceState;
    MyAdapter adapter;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.recyclerView1);
        adapter = new MyAdapter(getActivity(),getData());
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserLearnedDrawer = Boolean.valueOf(readFromPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,"false"));
        if (savedInstanceState!=null)
        {
            mFromSavedInstanceState = true;
        }
    }



    public void setup(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(),drawerLayout,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if(!mUserLearnedDrawer)
                {
                    mUserLearnedDrawer = true;
                    saveToPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,mUserLearnedDrawer+"");
                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                if(slideOffset < 0.6)
                toolbar.setAlpha(1-slideOffset);
            }
        };



        if(!mUserLearnedDrawer && !mFromSavedInstanceState)
        {
            mDrawerLayout.openDrawer(containerView);
        }

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });
    }
    public static void saveToPreferences(Context context,String preferenceName,String prefenceValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("myFile",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName,prefenceValue);
        editor.apply();
    }
    public static String readFromPreferences(Context context,String getPreferenceName,String getPreferenceValue)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences("myFile",Context.MODE_PRIVATE);
        return sharedPreferences.getString(getPreferenceName,getPreferenceValue);
    }

    public static List<Information> getData()
    {
        List<Information> data = new ArrayList<Information>();
        int images[] = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
        String[] title = {"Ronaldo","Ronaldino","zindan","bacham","rooney"};
        for(int i = 0; i < images.length && i < title.length; i++)
        {
            Information current = new Information();
            current.iconId = images[i];
            current.title = title[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public void itemClicked(View view, int possition) {
        startActivity(new Intent(getActivity(),SubActivity.class));
    }
}
