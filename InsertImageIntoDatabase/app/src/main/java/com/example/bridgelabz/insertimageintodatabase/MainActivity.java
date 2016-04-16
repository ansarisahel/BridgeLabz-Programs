package com.example.bridgelabz.insertimageintodatabase;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URI;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1,imageView2;
    Button button1,button2,button3;
    MyDatabase database;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        database = new MyDatabase(this);
        Toast.makeText(MainActivity.this, Environment.getDataDirectory().toString(), Toast.LENGTH_LONG).show();
    }

    public void saveIntoDBClick(View view) {
        database = new MyDatabase(this);
        Drawable drawable = imageView1.getDrawable();
        BitmapDrawable bitmapDrawable = ((BitmapDrawable) drawable);
        Bitmap bitmap = bitmapDrawable.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,70,stream);
        byte[] byteStream = stream.toByteArray();
        Toast.makeText(MainActivity.this, byteStream.toString(), Toast.LENGTH_SHORT).show();

      //  long rows = database.insertImage(uri.toString());
       /* long rows = database.insertImage(byteStream);
        if(rows > 0)
            Toast.makeText(MainActivity.this, "image inserted successfully", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();*/
      //  Bitmap bitmap = BitmapFactory.
       // imageView2.setImageDrawable(copiedImage);
    }

    public void onRetrieveBtnClick(View view) {
        String imageString = database.retrieveImage();
        Uri image_uri = Uri.parse(imageString);
        imageView2.setImageURI(image_uri);
        /*ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.dot_net1);
        bitmap.compress(Bitmap.CompressFormat.JPEG,70,stream);
        byte[] bytes = stream.toByteArray();
        String encodedImage = Base64.encodeToString(bytes, Base64.DEFAULT);
        Toast.makeText(MainActivity.this, encodedImage, Toast.LENGTH_LONG).show();

        Bitmap bitmap2 = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
        imageView2.setImageBitmap(bitmap2);*/
    }

    public void onLoadBtnClick(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        startActivityForResult(intent,1);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK && requestCode == 1)
        {
            uri = data.getData();
            Log.e("Selected Image uri is =",uri.toString());
            Log.e("image path",uri.getPath());
            String path = uri.toString();
            imageView1.setImageURI(uri);
        }
    }
}
