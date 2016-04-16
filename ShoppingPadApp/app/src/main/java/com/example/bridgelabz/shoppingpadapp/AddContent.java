package com.example.bridgelabz.shoppingpadapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class AddContent extends ActionBarActivity {

    private static final int SELECT_PICTURE = 2;
    ImageView imageView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__content);
        imageView = (ImageView) findViewById(R.id.add_content_imageView);
        toolbar = (Toolbar) findViewById(R.id.add_content_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Content");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // code for getting the image uri selected from the galaary and set the image in the imageview using uri...
        Bundle bundle = getIntent().getExtras();
        Bitmap photo = bundle.getParcelable("data");
        if(bundle != null)
        imageView.setImageBitmap(photo);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void onImageViewBtnClicked(View view) {
        Intent intent = new Intent();
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
        }
        catch (ActivityNotFoundException e) {

        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK)
        {
            if(requestCode == SELECT_PICTURE)
            {
                Bundle extras = data.getExtras();

                if(extras != null)
                {
                    Bitmap photo = extras.getParcelable("data");
                    imageView.setImageBitmap(photo);
                }

            }
        }

    }

    public void onSaveBtnClick(View view) {
        Toast.makeText(AddContent.this, "Save Btn Clicked", Toast.LENGTH_SHORT).show();
    }
}
