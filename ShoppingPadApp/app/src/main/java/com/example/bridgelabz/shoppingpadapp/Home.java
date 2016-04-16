package com.example.bridgelabz.shoppingpadapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import com.example.bridgelabz.shoppingpadapp.controller.HomeController;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class Home extends ActionBarActivity {

    private static final int SELECT_PICTURE = 1;
    Toolbar toolbar;
    SlidingTabLayout mTabs;
    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mTabs = (SlidingTabLayout) findViewById(R.id.tabs);
        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTabs.setDistributeEvenly(true);
        mTabs.setViewPager(mPager);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);  // this will give the clickable button for opening and closing navigation drawer.
        getSupportActionBar().setHomeButtonEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp((DrawerLayout) findViewById(R.id.drawer_layout), toolbar);


        // Coding for floating btn in an activity......................................
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.plus);

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setContentView(imageView)
                .setBackgroundDrawable(R.drawable.button_action_red)
                .build();


        ImageView floatingBtnOption1 = new ImageView(this);
        floatingBtnOption1.setImageResource(R.drawable.facebook_f_logo);
        ImageView floatingBtnOption2 = new ImageView(this);
        floatingBtnOption2.setImageResource(R.drawable.facebook_f_logo);
        ImageView floatingBtnOption3 = new ImageView(this);
        floatingBtnOption3.setImageResource(R.drawable.facebook_f_logo);

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        SubActionButton imageSelect = itemBuilder.setContentView(floatingBtnOption1).build();
        SubActionButton videoSelect = itemBuilder.setContentView(floatingBtnOption2).build();
        SubActionButton button3 = itemBuilder.setContentView(floatingBtnOption3).build();

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(imageSelect)
                .addSubActionView(videoSelect)
                .addSubActionView(button3)
                .attachTo(actionButton)
                .build();



        imageSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeController.onFloatImageBtnClick(Home.this);
               /* Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                // ******** code for crop image
                intent.putExtra("crop", "true");
                intent.putExtra("aspectX", 0);
                intent.putExtra("aspectY", 0);
                intent.putExtra("outputX", 200);
                intent.putExtra("outputY", 150);

                try {
                    intent.putExtra("return-data", true);
                    startActivityForResult(Intent.createChooser(intent, "select picture"), SELECT_PICTURE);
                } catch (ActivityNotFoundException e) {

                }   */
            }
        });


        videoSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeController.onFloatVideoBtnClick(Home.this);
               // startActivity(new Intent(Home.this, ViewContent.class));
            }
        });


        // end of floating btn coding.......................................

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Bundle extras = data.getExtras();
                HomeController.onActivityResult(this,extras);
                //startActivity(new Intent(this, AddContent.class).putExtras(extras));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }


}       // end of class
