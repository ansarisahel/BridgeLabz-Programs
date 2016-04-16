package com.example.bridgelabz.shoppingpadapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ViewContent extends ActionBarActivity {

    View view;
    Toolbar toolbar;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_content);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
       // toolbar = (Toolbar) layout.findViewById(R.id.viewContentToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void onToolbarImageClicked(View view)
    {
        Toast.makeText(ViewContent.this,"Image Cliked",Toast.LENGTH_SHORT).show();
    }

    public void onImageBtnClicked(View view)
    {
        Toast.makeText(ViewContent.this,Integer.toString(view.getId()) ,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.selectedIcon)
            Toast.makeText(this,"icon",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }*/
}
