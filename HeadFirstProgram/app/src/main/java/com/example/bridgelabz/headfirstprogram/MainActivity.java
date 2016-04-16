package com.example.bridgelabz.headfirstprogram;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends Activity {


    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView1);
        IotdHandler handler = new IotdHandler();
        handler.processFeed();

       // resetDisplay(handler.getTitle(),handler.getDate(),handler.getImage(),handler.getDescription());

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void resetDisplay(String title, String date, Bitmap imageUrl, StringBuffer description) {
        TextView titleView = (TextView)findViewById(R.id.textViewTile);
        titleView.setText(title);

        TextView dateView = (TextView)findViewById(R.id.textViewDate);
        dateView.setText(date);

        ImageView imageView = (ImageView)findViewById(R.id.imageView1);
        imageView.setImageBitmap(imageUrl);

        TextView descriptionView = (TextView)findViewById(R.id.textViewDescription);
        descriptionView.setText(description);

    }

    public void onRefresh(View view) {

       final ProgressDialog dialog = ProgressDialog.show(this,"loading","image is loading");

        Thread t1 = new Thread()
        {
            public void run()
            {
                try {
                    this.sleep(5000);
                    dialog.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        t1.start();


        /*IotdHandler handler = new IotdHandler();
        handler.processFeed();

         resetDisplay(handler.getTitle(),handler.getDate(),handler.getImage(),handler.getDescription());*/

    }

    public void setWallpaper(View view) {

        final Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        Toast.makeText(getBaseContext(),"setting wallpapper",Toast.LENGTH_SHORT).show();
        Thread t1 = new Thread()
        {
            public void run()
            {
                try {
                    WallpaperManager wallpaperManager = WallpaperManager.getInstance(MainActivity.this);
                    wallpaperManager.setBitmap(bitmap);
                    Toast.makeText(getBaseContext(),"wallpapper has been set",Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
    }// end of set Wallpaper method



}       //end of class
